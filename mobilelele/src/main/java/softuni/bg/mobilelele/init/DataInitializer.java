package softuni.bg.mobilelele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import softuni.bg.mobilelele.service.BrandService;
import softuni.bg.mobilelele.service.ModelService;
import softuni.bg.mobilelele.service.OfferService;
import softuni.bg.mobilelele.service.UserService;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;

    public DataInitializer(UserService userService, BrandService brandService, ModelService modelService, OfferService offerService) {

        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initializeUsersAndRoles();
        brandService.initializeBrands();
        modelService.initializeModels();
        offerService.initializeOffers();


    }
}
