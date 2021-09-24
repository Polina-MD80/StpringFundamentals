package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
}
