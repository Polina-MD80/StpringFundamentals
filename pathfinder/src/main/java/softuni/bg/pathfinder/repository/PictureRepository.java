package softuni.bg.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.pathfinder.model.entity.Picture;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture,Long> {
    @Override
    List<Picture> findAll();
}
