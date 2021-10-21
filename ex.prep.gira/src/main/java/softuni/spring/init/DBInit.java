package softuni.spring.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.spring.service.ClassificationService;

@Component
public class DBInit implements CommandLineRunner {
   private final ClassificationService classificationService;

    public DBInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
       classificationService.initializeClassifications();
    }
}
