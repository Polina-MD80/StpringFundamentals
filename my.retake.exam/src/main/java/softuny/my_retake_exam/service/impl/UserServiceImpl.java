package softuny.my_retake_exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuny.my_retake_exam.model.entity.UserEntity;
import softuny.my_retake_exam.model.service.UserServiceModel;
import softuny.my_retake_exam.repository.UserRepository;
import softuny.my_retake_exam.service.UserService;
import softuny.my_retake_exam.user.CurrentUser;

import java.util.Optional;


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

            userRepository.save(userEntity);



        return true;
    }


    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
       UserEntity userEntity = userRepository.findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword()).orElse(null);
            if (userEntity == null){
            return false;
        }
        currentUser.setId(userEntity.getId())
                .setUsername(userEntity.getUsername());
        return true;
    }

    @Override
    public boolean isUserNameFree(String userName) {
        return !userRepository.existsByUsername(userName.toLowerCase());
    }





}
