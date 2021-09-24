package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
