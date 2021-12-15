package softuny.my_retake_exam.service;


import softuny.my_retake_exam.model.service.UserServiceModel;

public interface UserService {

  boolean registerUser(UserServiceModel map);


  boolean loginUser(UserServiceModel userServiceModel);

  boolean isUserNameFree(String userName);

}
