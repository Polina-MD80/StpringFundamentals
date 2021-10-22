package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmailAndPassword(String email, String password);


    Optional<UserEntity> findUserEntityByEmail(String email);

    Optional<UserEntity> findById(Long id);

    boolean existsByEmail(String email);
}
