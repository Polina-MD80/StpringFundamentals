package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.AlbumEntity;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
