package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private RoleName roleName;

  public Role() {
  }

  public RoleName getRoleName() {
    return roleName;
  }

  public void setRoleName(RoleName roleName) {
    this.roleName = roleName;
  }
}
