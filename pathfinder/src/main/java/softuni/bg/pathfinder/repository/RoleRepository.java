package softuni.bg.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.pathfinder.model.entity.Role;
import softuni.bg.pathfinder.model.entity.enums.RoleNameEnum;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleNameEnum roleName);
}
