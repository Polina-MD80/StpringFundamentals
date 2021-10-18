package softuni.spring.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.spring.service.CategoryService;

@Component
public class DataBaseInit implements CommandLineRunner {
    private final CategoryService categoryService;

    public DataBaseInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initializeCategories();
    }
}
