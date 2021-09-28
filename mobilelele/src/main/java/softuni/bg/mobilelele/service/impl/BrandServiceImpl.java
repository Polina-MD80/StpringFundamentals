package softuni.bg.mobilelele.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.models.entity.Brand;
import softuni.bg.mobilelele.models.entity.Model;
import softuni.bg.mobilelele.models.enums.Category;
import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.service.BrandService;

import java.time.Instant;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrands() {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");
            //ford.setCreated(Instant.now());

            brandRepository.save(ford);
        }
    }

    @Override
    public Brand findBrandByName(String name) {
        return brandRepository.findByName(name);
    }
}