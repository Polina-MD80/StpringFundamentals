package softuni.spring.service.impl;

import org.springframework.stereotype.Service;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.enums.CategoryNameEnum;
import softuni.spring.repository.CategoryRepository;
import softuni.spring.service.CategoryService;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new CategoryEntity(CategoryNameEnum.CARGO, "This is Cargo category"));
            categoryRepository.save(new CategoryEntity(CategoryNameEnum.BATTLE, "This is Battle category"));
            categoryRepository.save(new CategoryEntity(CategoryNameEnum.PATROL, "This is Patrol category"));
        }
    }

    @Override
    public Optional<CategoryEntity> findBuCategoryEnumName(CategoryNameEnum nameEnum) {
        return categoryRepository.findCategoryEntityByName(nameEnum);
    }
}
