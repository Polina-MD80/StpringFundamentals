package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  boolean existsByUsername(String username);
 Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
