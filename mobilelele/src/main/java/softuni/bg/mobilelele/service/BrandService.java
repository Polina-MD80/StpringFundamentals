package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.models.entity.Brand;

import java.util.Optional;

public interface BrandService {

    void initializeBrands();

    Brand findBrandByName(String name);
}
