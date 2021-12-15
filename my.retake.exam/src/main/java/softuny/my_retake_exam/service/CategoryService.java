package softuny.my_retake_exam.service;


import softuny.my_retake_exam.model.entity.CategoryEntity;
import softuny.my_retake_exam.model.entity.enums.CategoryName;

public interface CategoryService {
    void initializeCategories();

    CategoryEntity findByName(CategoryName category);
}
