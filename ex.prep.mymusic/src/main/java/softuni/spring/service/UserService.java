package softuni.spring.service;

import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String username, String password);

    void login(UserServiceModel user);

    UserEntity findUserById(Long id);
}
