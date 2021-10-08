package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.models.binding.UserRegistrationBindingModel;
import softuni.bg.mobilelele.models.entity.User;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;
import softuni.bg.mobilelele.models.service.UserRegistrationServiceModel;

import java.util.Optional;

public interface UserService {

    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel user);

    void logOut();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

}
