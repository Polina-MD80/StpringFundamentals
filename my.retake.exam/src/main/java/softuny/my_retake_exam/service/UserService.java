package softuny.my_retake_exam.service;


import softuny.my_retake_exam.model.entity.UserEntity;
import softuny.my_retake_exam.model.service.UserServiceModel;

public interface UserService {

    boolean isUserNameFree(String userName);

 boolean registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel userServiceModel);


    UserEntity findById(Long id);
}
