package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.repository.UserRepository;
import softuni.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final  UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public boolean isUserNameFree(String userName) {
//        return !userRepository.exists(userName);
//    }
//    private final CurrentUser currentUser;
//    private final UserRepository userRepository;
//    private final ModelMapper modelMapper;
//
//    public UserServiceImpl(CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
//        this.currentUser = currentUser;
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public boolean registerUser(UserServiceModel map) {
//        return false;
//    }
//
//    @Override
//    public UserServiceModel findByUsernameAndPassword(String username, String password) {
//        return userRepository.findByUsernameAndPassword(username, password)
//                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
//                .orElse(null);
//    }
//    @Override
//    public void loginUser(UserServiceModel userServiceModel) {
//        currentUser.setId(userServiceModel.getId())
//                .setUsername(userServiceModel.getUsername());
//    }


//    @Override
//    public UserEntity findById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }


}
