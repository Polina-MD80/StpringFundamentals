package softuni.spring.service;

import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {
    void initializeCategories();

   Optional<CategoryEntity> findBuCategoryEnumName(CategoryNameEnum nameEnum);

}
