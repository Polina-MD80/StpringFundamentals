package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Override
    List<Offer> findAll();
}
