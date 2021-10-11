package softuni.bg.pathfinder.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserProfileController {
    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model){
        System.out.println("Req Profile?");
        model.addAttribute("user", userService.findByUsername(username));
        return "profile";
    }
}
