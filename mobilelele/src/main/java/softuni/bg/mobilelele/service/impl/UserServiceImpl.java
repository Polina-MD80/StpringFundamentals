package softuni.bg.mobilelele.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.User;
import softuni.bg.mobilelele.models.entity.UserRole;
import softuni.bg.mobilelele.models.enums.Role;
import softuni.bg.mobilelele.models.service.UserLoginServiceModel;
import softuni.bg.mobilelele.repository.RoleRepository;
import softuni.bg.mobilelele.user.CurrentUser;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.roleRepository = roleRepository;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {

        if (userRepository.count() == 0) {
            UserRole adminRole = roleRepository.findByName(Role.ADMIN);
            UserRole userRole = roleRepository.findByName(Role.USER);


            User admin = new User();
            admin.setFirstName("Polina");
            admin.setLastName("Pavlova");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("test"));
            admin.setActive(true);
            admin.setRoles(Set.of(adminRole,userRole));

            User pesho = new User();
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setUsername("pesho");
            pesho.setPassword(passwordEncoder.encode("test"));
            pesho.setActive(true);
            pesho.setRoles(Set.of(userRole));

            userRepository.saveAll(List.of(admin,pesho));
        }
    }

    private void initializeRoles() {
        if (userRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setName(Role.ADMIN);
            UserRole userRole = new UserRole();
            userRole.setName(Role.USER);
            roleRepository.saveAll(List.of(adminRole, userRole));
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
        user.getRoles().forEach(r-> currentUser.addRole(r.getName()));
    }

    @Override
    public void logOut() {
        currentUser.clean();
    }
}
