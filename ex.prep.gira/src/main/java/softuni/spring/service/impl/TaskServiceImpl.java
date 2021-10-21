package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.TaskEntity;
import softuni.spring.model.entity.enums.ProgressEnum;
import softuni.spring.model.service.TaskServiceModel;
import softuni.spring.model.view.TaskViewModel;
import softuni.spring.repository.TaskRepository;
import softuni.spring.service.ClassificationService;
import softuni.spring.service.TaskService;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final CurrentUser currentUser;


    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository, ClassificationService classificationService, UserService userService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;

        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.userService = userService;
        this.currentUser = currentUser;
    }


    @Override
    public void add(TaskServiceModel taskServiceModel) {
        TaskEntity taskEntity = modelMapper.map(taskServiceModel, TaskEntity.class);
        taskEntity.setClassification(classificationService.findBy(taskServiceModel.getClassification()));
        taskEntity.setProgress(ProgressEnum.OPEN);
        if (currentUser.getId() != null) {
            taskEntity.setAssignedTo(userService.findById(currentUser.getId()));

        }
        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskViewModel> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void changeProgress(Long id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);

        if (task != null) {
            if (task.getProgress() == ProgressEnum.COMPLETED || task.getProgress() == ProgressEnum.OTHER) {
                taskRepository.delete(task);
            } else {
                if (task.getProgress() == ProgressEnum.OPEN) {
                    task.setProgress(ProgressEnum.IN_PROGRESS);
                } else if (task.getProgress() == ProgressEnum.IN_PROGRESS) {
                    task.setProgress(ProgressEnum.COMPLETED);
                }

                taskRepository.save(task);
            }

        }
    }
}
