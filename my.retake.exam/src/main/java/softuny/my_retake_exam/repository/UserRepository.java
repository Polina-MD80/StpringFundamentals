package softuny.my_retake_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuny.my_retake_exam.model.entity.UserEntity;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   Optional<UserEntity> findByUsernameAndPassword(String username, String password);

   boolean existsByUsername(String username);
}
