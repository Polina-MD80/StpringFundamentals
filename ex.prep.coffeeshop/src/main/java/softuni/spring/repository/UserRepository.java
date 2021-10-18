package softuni.spring.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.spring.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    @Query("select u from UserEntity u order by size(u.orders) desc ")
    List<UserEntity> findAllByOrdersDesc();

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
