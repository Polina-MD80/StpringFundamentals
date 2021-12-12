package softuny.my_retake_exam.model.binding;



import softuny.my_retake_exam.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters")
    @UniqueUserName
    private String username;
    @NotBlank
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters")
    private String fullName;
    @NotNull
    @Size(min = 3, message = "Password length must more than 3 characters")
    private String password;
    @NotNull
    @Size(min = 3, message = "Password length must more than 3 characters")
    private String confPassword;
    @Email(message = "Enter valid email format")
    @NotBlank(message = "email cann not be empty")
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
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
