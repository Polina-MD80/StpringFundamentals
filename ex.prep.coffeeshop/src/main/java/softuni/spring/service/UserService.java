package softuni.spring.service;

import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;
import softuni.spring.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    boolean registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel userServiceModel);


    UserEntity findById(Long id);

    List<UserViewModel> findAllUsersByCountOfOrdersDesc();

}
