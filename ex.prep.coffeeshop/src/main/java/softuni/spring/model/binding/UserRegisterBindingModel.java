package softuni.spring.model.binding;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {
    @NotBlank
    @Size(min = 5, max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message = "Last name length must be between 5 and 20 characters.")
    private String lastName;
    @Email(message = "Enter valid email")
    private String email;
    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
    private String password;
    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
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

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
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
