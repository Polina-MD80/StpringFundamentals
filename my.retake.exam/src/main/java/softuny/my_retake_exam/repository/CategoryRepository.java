package softuny.my_retake_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import softuny.my_retake_exam.model.entity.CategoryEntity;
import softuny.my_retake_exam.model.entity.enums.CategoryName;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(CategoryName name);

}
