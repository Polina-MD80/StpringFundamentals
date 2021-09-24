package softuni.bg.mobilelele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.mobilelele.models.entity.Brand;
import softuni.bg.mobilelele.models.entity.enums.Category;
import softuni.bg.mobilelele.models.entity.Model;
import softuni.bg.mobilelele.repository.BrandRepository;

import java.time.Instant;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;

    public DataInitializer(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");
            ford.setCreated(Instant.now());

            Model fiesta = new Model();
            fiesta.setBrand(ford);
            fiesta.setCategory(Category.CAR);
            fiesta.setName("Fiesta");
            fiesta.setStartYear(1976);
            fiesta.setImageUrl(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");

            Model escort = new Model();
            escort.setBrand(ford);
            escort.setCategory(Category.CAR);
            escort.setName("Escort");
            escort.setStartYear(1967);
            escort.setEndYear(2004);
            escort.setImageUrl(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg");

            ford.setModels(List.of(escort, fiesta));

            brandRepository.save(ford);
        }
    }
}
