package softuni.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.spring.user.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping()
    public String home(Model model){
        if (currentUser.getId()==null){
            return "index";
        }
        //ToDo model.addAttributes()

        return "home";
    }
}
