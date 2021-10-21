package softuni.spring.service;

import softuni.spring.model.service.TaskServiceModel;
import softuni.spring.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel taskServiceModel);
    List<TaskViewModel> findAllTasks();

    void changeProgress(Long id);
}
