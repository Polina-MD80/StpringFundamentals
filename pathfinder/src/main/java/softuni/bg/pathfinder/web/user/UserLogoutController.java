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
    private final CurrentUser currentUser;

    public UserLogoutController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
