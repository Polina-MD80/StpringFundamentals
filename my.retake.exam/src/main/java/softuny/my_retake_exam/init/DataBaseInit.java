package softuny.my_retake_exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuny.my_retake_exam.service.CategoryService;


@Component
public class DataBaseInit implements CommandLineRunner {
    private final CategoryService categoryService;

    public DataBaseInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
      categoryService.initializeCategories();
    }
}
