package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.mobilelele.models.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
