package softuni.spring.web;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.spring.model.entity.enums.ClassificationNameEnum;
import softuni.spring.model.entity.enums.ProgressEnum;
import softuni.spring.service.TaskService;
import softuni.spring.user.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        model.addAttribute("tasks",taskService.findAllTasks() );
        model.addAttribute("progresses", ProgressEnum.values());
        model.addAttribute("classifications", ClassificationNameEnum.values());
        return "home";
    }
}
