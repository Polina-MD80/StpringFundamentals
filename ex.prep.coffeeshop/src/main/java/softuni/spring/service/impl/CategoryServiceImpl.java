package softuni.spring.service.impl;

import org.springframework.stereotype.Service;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryName;
import softuni.spring.repository.CategoryRepository;
import softuni.spring.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new CategoryEntity(CategoryName.Drink, 1));
            categoryRepository.save(new CategoryEntity(CategoryName.Coffee, 2));
            categoryRepository.save(new CategoryEntity(CategoryName.Other, 5));
            categoryRepository.save(new CategoryEntity(CategoryName.Cake, 10));
        }
    }

    @Override
    public CategoryEntity findByName(CategoryName category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
