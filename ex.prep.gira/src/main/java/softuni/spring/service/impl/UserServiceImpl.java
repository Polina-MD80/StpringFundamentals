package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.UserServiceModel;
import softuni.spring.repository.UserRepository;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        try {
            userRepository.save(userEntity);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean isUserExist(String email, String password) {
        if (userRepository.existsByEmail(email)){
            UserEntity userEntityByEmail = userRepository.findUserEntityByEmail(email).orElse(null);
            if (userEntityByEmail!=null){
                return passwordEncoder.matches(password, userEntityByEmail.getPassword());
            }
        }
        return false;
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = userRepository.findUserEntityByEmail(userServiceModel.getEmail()).orElse(null);

        assert userEntity != null;
        currentUser.setId(userEntity.getId());
        currentUser.setUsername(userEntity.getUsername());
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isEmailFree(String email) {
        return !userRepository.existsByEmail(email);
    }
}
