package softuni.bg.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.pathfinder.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
