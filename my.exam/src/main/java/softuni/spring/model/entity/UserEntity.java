package softuni.spring.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShipEntity> ships;

    public List<ShipEntity> getShips() {
        return ships;
    }

    public UserEntity setShips(List<ShipEntity> ships) {
        this.ships = ships;
        return this;
    }

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
}
