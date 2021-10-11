package softuni.bg.pathfinder.model.view;

import softuni.bg.pathfinder.model.entity.Role;
import softuni.bg.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

public class UserProfileView {

    private Integer age;

    private String fullName;

    private String password;

    private String email;

    private Level level;

    private String username;

    private Set<Role> roles;

    public Integer getAge() {
        return age;
    }

    public UserProfileView setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserProfileView setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileView setEmail(String email) {
        this.email = email;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public UserProfileView setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileView setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserProfileView setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}
