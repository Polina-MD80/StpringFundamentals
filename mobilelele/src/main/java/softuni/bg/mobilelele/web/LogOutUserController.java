package softuni.bg.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.bg.mobilelele.service.UserService;
import softuni.bg.mobilelele.user.CurrentUser;

@Controller
public class LogOutUserController {
    private final UserService userService;

    public LogOutUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    private String logout(){
        userService.logOut();
        System.out.println("loggedOut!!!!!!");
        return "redirect:/";
    }
}
