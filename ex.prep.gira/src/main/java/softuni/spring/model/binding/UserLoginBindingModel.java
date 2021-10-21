package softuni.spring.model.binding;

import javax.validation.constraints.*;

public class UserLoginBindingModel {
    @Email
    @NotEmpty(message = "Email cant be empty")
    private String email;
    @NotBlank
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
