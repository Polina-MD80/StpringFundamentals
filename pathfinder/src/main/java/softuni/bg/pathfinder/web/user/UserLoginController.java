package softuni.bg.pathfinder.web.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.pathfinder.model.binding.UserLoginBindingModel;
import softuni.bg.pathfinder.model.service.UserLoginServiceModel;
import softuni.bg.pathfinder.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserLoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("loginBindingModel")
    public UserLoginBindingModel loginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }
        UserLoginServiceModel userLoginServiceModel = modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class);
        boolean successful = userService.login(userLoginServiceModel);
        if (!successful) {
            return "redirect:login";
        }
        return "redirect:/";
    }

}
