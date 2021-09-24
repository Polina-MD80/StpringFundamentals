package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
