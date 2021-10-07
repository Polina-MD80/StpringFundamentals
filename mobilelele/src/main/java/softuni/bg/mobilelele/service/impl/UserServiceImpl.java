package softuni.bg.mobilelele.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.User;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;
import softuni.bg.mobilelele.user.CurrentUser;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void initializeUsers() {
        if (userRepository.count() == 0) {
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

        if (optUser.isEmpty()) {
            logOut();
            return false;
        } else {
            boolean success =
                    passwordEncoder.matches(userLoginServiceModel.getRawPassword(), optUser.get().getPassword());
            if (success) {
                User loggedInUser = optUser.get();
                login(loggedInUser);
            }
            return success;
        }

    }

    private void login(User user) {
        currentUser.setLoggedIn(true)
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());
    }

    @Override
    public void logOut() {
        currentUser.clean();
    }
}
