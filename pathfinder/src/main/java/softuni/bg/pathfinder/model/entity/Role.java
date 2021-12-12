package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private RoleNameEnum roleName;

  public Role() {
  }

  public RoleNameEnum getRoleName() {
    return roleName;
  }

  public void setRoleName(RoleNameEnum roleName) {
    this.roleName = roleName;
  }
}
