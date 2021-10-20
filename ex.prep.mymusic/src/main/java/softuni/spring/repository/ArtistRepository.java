package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.ArtistEntity;
import softuni.spring.model.entity.enums.ArtistEnumName;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    Optional<ArtistEntity> findByName(ArtistEnumName name);
}
