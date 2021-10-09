package softuni.bg.mobilelele.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.mobilelele.models.binding.UserRegistrationBindingModel;
import softuni.bg.mobilelele.models.service.UserRegistrationServiceModel;
import softuni.bg.mobilelele.service.UserService;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/users/register")
    public ModelAndView registerUser(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @ModelAttribute("userModel")
    public UserRegistrationBindingModel userModel() {
        return new UserRegistrationBindingModel();
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegistrationBindingModel userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        //TODO validation
        UserRegistrationServiceModel serviceModel = modelMapper
                .map(userModel, UserRegistrationServiceModel.class);

        if (!userService.isUserNameFree(serviceModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("userNameOccupied", true);
            return "redirect:/users/register";
        }
        userService.registerAndLoginUser(serviceModel);
        return "redirect:/";
    }
}
