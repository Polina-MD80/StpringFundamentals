package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryName;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

 Optional<CategoryEntity>  findByName(CategoryName name);
}
