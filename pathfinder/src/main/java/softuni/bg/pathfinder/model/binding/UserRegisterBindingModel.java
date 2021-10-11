package softuni.bg.pathfinder.model.binding;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {
    @Size(min = 3)
    @NotBlank
    private String username;
    @Size(min = 3)
    @NotBlank
    private String fullName;
    @Email
    private String email;
    @Min(10)
    private Integer age;

    private String password;

    private String confPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public UserRegisterBindingModel setConfPassword(String confPassword) {
        this.confPassword = confPassword;
        return this;
    }
}
