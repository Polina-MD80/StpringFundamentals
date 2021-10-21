package softuni.spring.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring.model.binding.AddTaskBindingModel;
import softuni.spring.model.service.TaskServiceModel;
import softuni.spring.service.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskController(ModelMapper modelMapper, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @GetMapping("add")
    public String add(){
        return "add-task";
    }

    @ModelAttribute
    public AddTaskBindingModel addTaskBindingModel(){
        return new AddTaskBindingModel();
    }
    @PostMapping("add")
    public String confAdd(@Valid AddTaskBindingModel addTaskBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addTaskBindingModel",addTaskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel",bindingResult);

            return "redirect:add";
        }

        TaskServiceModel taskServiceModel = modelMapper.map(addTaskBindingModel, TaskServiceModel.class);
        taskService.add(taskServiceModel);

        return "redirect:/";

    }

    @GetMapping("progress/{id}")
    public String changeProgress(@PathVariable Long id){
        taskService.changeProgress(id);

        return "redirect:/";
    }
}
