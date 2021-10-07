package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.BaseEntity;
import softuni.bg.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    //id, age, full_name, level, password, username)
    @Column
    private Integer age;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column()
    private String email;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false, unique = true)
    private String username;
    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
