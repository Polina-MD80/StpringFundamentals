package softuni.bg.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.pathfinder.model.entity.Role;
import softuni.bg.pathfinder.model.entity.User;
import softuni.bg.pathfinder.model.entity.enums.LevelEnum;
import softuni.bg.pathfinder.model.entity.enums.RoleNameEnum;
import softuni.bg.pathfinder.model.service.UserLoginServiceModel;
import softuni.bg.pathfinder.model.service.UserRegisterServiceModel;
import softuni.bg.pathfinder.model.view.UserProfileView;
import softuni.bg.pathfinder.repository.RoleRepository;
import softuni.bg.pathfinder.repository.UserRepository;
import softuni.bg.pathfinder.service.UserService;
import softuni.bg.pathfinder.util.CurrentUser;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncode;
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, PasswordEncoder passwordEncode, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.passwordEncode = passwordEncode;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean usernameExists(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public User register(UserRegisterServiceModel registerServiceModel) {
        Role roleUser = this.roleRepository.findByRoleName(RoleNameEnum.USER);
        Role roleAdmin = this.roleRepository.findByRoleName(RoleNameEnum.ADMIN);
        registerServiceModel.getRoles().add(roleUser);
        if (userRepository.count() == 0) {
            registerServiceModel.getRoles().add(roleAdmin);
        }
        User newUser = modelMapper.map(registerServiceModel, User.class);

        newUser.setLevel(LevelEnum.BEGINNER);
        System.out.println("Can we just register?");
        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        User user = this.userRepository.findByUsername(userLoginServiceModel.getUsername());
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(userLoginServiceModel.getPassword())) {
            loginUser(user);
            System.out.printf("%s is logged in", user.getUsername());
            return true;
        }

        return false;
    }

    private void loginUser(User user) {
        currentUser.setUsername(user.getUsername())
                .setFullName(user.getFullName())
                .setLoggedIn(true)
                .setRoles(user.getRoles())
                .setId(user.getId());
    }

    public void logout() {
        currentUser.clearCurrentUser();
    }

    @Override
    public UserProfileView findByUsername(String username) {
        return modelMapper.map(userRepository.findByUsername(username), UserProfileView.class);
    }

    @Override
    public User findCurrentUserEntity() {

        return userRepository.findById(currentUser.getId()).orElse(null);
    }
}
