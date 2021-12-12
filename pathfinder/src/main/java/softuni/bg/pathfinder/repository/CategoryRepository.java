package softuni.bg.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.pathfinder.model.entity.Category;
import softuni.bg.pathfinder.model.entity.enums.CategoryNameEnum;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategoryNameEnum category);

}
