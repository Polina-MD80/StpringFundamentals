package softuni.bg.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.bg.pathfinder.model.entity.Route;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAll();

    Optional<Route> findById(Long id);
}
