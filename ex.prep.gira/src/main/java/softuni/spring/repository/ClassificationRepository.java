package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.ClassificationEntity;
import softuni.spring.model.entity.enums.ClassificationNameEnum;

import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Long> {

    Optional<ClassificationEntity> findByClassificationName(ClassificationNameEnum name);
}
