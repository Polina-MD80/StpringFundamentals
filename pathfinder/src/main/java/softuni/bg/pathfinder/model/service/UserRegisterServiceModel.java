package softuni.bg.pathfinder.model.service;

import softuni.bg.pathfinder.model.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class UserRegisterServiceModel {

    private String username;
    private String password;
    private String fullName;
    private String email;
    private Integer age;
    private Set<Role> roles = new HashSet<>();

    public UserRegisterServiceModel() {
    }



    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserRegisterServiceModel setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
