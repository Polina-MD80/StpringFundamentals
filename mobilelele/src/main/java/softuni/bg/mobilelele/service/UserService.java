package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.models.entity.User;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;

import java.util.Optional;

public interface UserService {

    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel user);

    void logOut();

}
