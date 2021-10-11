package softuni.bg.pathfinder.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.bg.pathfinder.model.entity.Role;
import softuni.bg.pathfinder.model.entity.enums.RoleName;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private String username;
    private String fullName;
    private boolean isLoggedIn;
    private Set<Role> roles = new HashSet<>();

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public CurrentUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public CurrentUser setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public boolean isAdmin() {

        return this.getRoles().stream().map(role -> role.getRoleName().toString())
                .anyMatch(n -> n.equals("ADMIN"));
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void clearRoles() {
        this.roles.clear();
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public void clearCurrentUser() {
        this.setLoggedIn(false)
                .setUsername(null)
                .setFullName(null)
                .clearRoles();
    }
}
