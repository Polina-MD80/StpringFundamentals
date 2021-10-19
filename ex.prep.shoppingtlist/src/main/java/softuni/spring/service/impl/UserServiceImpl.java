package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;
import softuni.spring.repository.UserRepository;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

@Service
public class UserServiceImpl implements UserService {
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        try{
            //here we check for unique username
            userRepository.save(userEntity);
        }catch (Exception e){
            return false;
        }


        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }
    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());
    }


//    @Override
//    public UserEntity findById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }


}
