package softuni.bg.pathfinder.service;

import softuni.bg.pathfinder.model.entity.User;
import softuni.bg.pathfinder.model.service.UserLoginServiceModel;
import softuni.bg.pathfinder.model.service.UserRegisterServiceModel;
import softuni.bg.pathfinder.model.view.UserProfileView;
import softuni.bg.pathfinder.util.CurrentUser;

public interface UserService {
    boolean usernameExists(String username);

    User register(UserRegisterServiceModel registerServiceModel);

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    UserProfileView findByUsername(String username);
}
