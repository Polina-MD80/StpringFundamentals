package softuni.bg.mobilelele.models.entity;

import softuni.bg.mobilelele.models.entity.enums.Role;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    @Enumerated
    private Role name;

    public UserRole() {
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
