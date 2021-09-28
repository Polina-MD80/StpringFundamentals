package softuni.bg.mobilelele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.service.BrandService;
import softuni.bg.mobilelele.service.ModelService;
import softuni.bg.mobilelele.service.UserService;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;

    public DataInitializer(UserService userService, BrandService brandService, ModelService modelService) {

        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initializeUsers();
        brandService.initializeBrands();
        modelService.initializeModels();


    }
}
