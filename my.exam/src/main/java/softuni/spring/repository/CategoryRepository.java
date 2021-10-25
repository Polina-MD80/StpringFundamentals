package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findCategoryEntityByName(CategoryNameEnum name);
}
