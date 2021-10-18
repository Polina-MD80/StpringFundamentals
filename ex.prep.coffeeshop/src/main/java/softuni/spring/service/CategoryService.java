package softuni.spring.service;

import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryName;

public interface CategoryService {
    void initializeCategories();

    CategoryEntity findByName(CategoryName category);

}
