package softuni.spring.service;

import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean isUserExist(String email, String password);

    void loginUser(UserServiceModel userServiceModel);

    UserEntity findById(Long id);

    boolean isEmailFree(String email);
}
