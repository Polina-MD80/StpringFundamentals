package softuni.bg.pathfinder.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.pathfinder.service.UserService;
import softuni.bg.pathfinder.util.CurrentUser;

@Controller
@RequestMapping("/users")
public class UserLogoutController {
    private final UserService userService;


    public UserLogoutController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
