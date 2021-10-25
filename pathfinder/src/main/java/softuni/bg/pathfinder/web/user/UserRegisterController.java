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
import softuni.bg.pathfinder.model.binding.UserRegisterBindingModel;
import softuni.bg.pathfinder.model.service.UserLoginServiceModel;
import softuni.bg.pathfinder.model.service.UserRegisterServiceModel;
import softuni.bg.pathfinder.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserRegisterController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("registerBindingModel")
    public UserRegisterBindingModel registerBindingModel() {
        return new UserRegisterBindingModel();
    }


    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel registerBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !registerBindingModel.getPassword().equals(registerBindingModel.getConfPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);
            System.out.println("I'm here");
            return "redirect:register";
        }

        UserRegisterServiceModel registerServiceModel = modelMapper.map(registerBindingModel, UserRegisterServiceModel.class);
        if (userService.usernameExists(registerServiceModel.getUsername())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel)
                    .addFlashAttribute("userNameOccupied", true);
            System.out.println("I'm there");
            return "redirect:register";

        }
        userService.register(registerServiceModel);

        return "redirect:login";
    }


}
