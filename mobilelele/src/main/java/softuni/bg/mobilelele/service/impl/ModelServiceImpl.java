package softuni.bg.mobilelele.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.Brand;
import softuni.bg.mobilelele.models.entity.Model;
import softuni.bg.mobilelele.models.enums.Category;
import softuni.bg.mobilelele.repository.ModelRepository;
import softuni.bg.mobilelele.service.BrandService;
import softuni.bg.mobilelele.service.ModelService;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
            Model fiesta = new Model();
            Model escort = new Model();
            Brand ford = brandService.findBrandByName("Ford");
            if (ford!=null) {
                fiesta.setBrand(ford);
                fiesta.setCategory(Category.CAR);
                fiesta.setName("Fiesta");
                fiesta.setStartYear(1976);
                fiesta.setImageUrl(
                        "https://upload.wikimedia.org/wikipedia/commons" +
                                "/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");


                escort.setBrand(ford);
                escort.setCategory(Category.CAR);
                escort.setName("Escort");
                escort.setStartYear(1967);
                escort.setEndYear(2004);
                escort.setImageUrl(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg");

                ford.setModels(List.of(escort, fiesta));
            }
            modelRepository.save(escort);
            modelRepository.save(fiesta);
        }
    }
}
