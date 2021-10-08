package softuni.bg.mobilelele.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.bg.mobilelele.models.binding.UserRegistrationBindingModel;
import softuni.bg.mobilelele.models.service.UserRegistrationServiceModel;
import softuni.bg.mobilelele.service.UserService;

@Controller
public class UserRegistrationController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/users/register")
    public String registerUser(){
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(UserRegistrationBindingModel userModel){
   //TODO validation
        UserRegistrationServiceModel serviceModel = modelMapper
                .map(userModel,UserRegistrationServiceModel.class);
        userService.registerAndLoginUser(serviceModel);

        return "redirect:/";
    }
}
