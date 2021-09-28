package softuni.bg.mobilelele.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.User;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
private final PasswordEncoder passwordEncoder;
private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public void initializeUsers() {
       if (userRepository.count() == 0){
        User admin = new User();
        admin.setFirstName("Polina");
        admin.setLastName("Pavlova");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("test"));
        admin.setActive(true);

        userRepository.save(admin);
       }
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<User> optUser = userRepository.findByUsername(userLoginServiceModel.getUsername());
        return optUser.filter(user -> passwordEncoder.matches(userLoginServiceModel.getRawPassword(),
                user.getPassword())).isPresent();
    }
}
