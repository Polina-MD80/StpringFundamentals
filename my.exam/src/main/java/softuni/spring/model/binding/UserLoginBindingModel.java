package softuni.spring.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters")
    private String username;
    @NotNull
    @Size(min = 3, message = "Password length must more than 3 characters")
    private String password;


    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
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
