package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Override
    List<TaskEntity> findAll();

    @Override
    Optional<TaskEntity> findById(Long id);
}
