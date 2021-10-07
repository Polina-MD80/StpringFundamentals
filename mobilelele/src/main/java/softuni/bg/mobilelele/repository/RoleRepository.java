package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.UserRole;
import softuni.bg.mobilelele.models.enums.Role;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(Role role);
}
