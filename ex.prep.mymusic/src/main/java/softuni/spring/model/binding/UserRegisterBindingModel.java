package softuni.spring.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters ")
    private String username;
    @NotBlank
    @Size(min = 3, max = 20, message = "Full Name length must be between 3 and 20 characters ")
    private String fullName;
    @NotBlank
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
    private String password;
    @NotNull
    @Email
    private String email;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
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

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
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
