package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;
import softuni.spring.repository.UserRepository;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        try {
            userRepository.save(userEntity);
        }catch (Exception e){
            return false;
        }
        return true ;
    }

    @Override
    public UserServiceModel findByUserNameAndPassword(String username, String password) {
    return     userRepository.findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel user) {
        currentUser.setId(user.getId());
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
