package softuni.spring.service.impl;

import org.springframework.stereotype.Service;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryName;
import softuni.spring.repository.CategoryRepository;
import softuni.spring.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count()==0){
            Arrays.stream(CategoryName.values()).forEach(categoryName -> {
                CategoryEntity categoryEntity = new CategoryEntity(categoryName,"This is " + categoryName.name() + " category.");
                categoryRepository.save(categoryEntity);
            });
        }
    }

    @Override
    public CategoryEntity findByName(CategoryName category) {

        return categoryRepository.findByName(category).orElse(null);
    }
}
