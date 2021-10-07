package softuni.bg.mobilelele.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import softuni.bg.mobilelele.models.binding.UserLoginBindingModel;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;
import softuni.bg.mobilelele.service.UserService;

@Controller
public class LoginUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserController.class);
    private final UserService userService;


    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {
        boolean loginSuccessful = userService.
                login(new UserLoginServiceModel().
                        setUsername(userLoginBindingModel.getUsername()).
                        setRawPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);

        if (loginSuccessful) {
            return "redirect:/";
        }
        return "redirect:/users/login";
    }

}


