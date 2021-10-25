package softuni.bg.pathfinder.service;

import softuni.bg.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutes();


    RouteViewModel findRouteById(Long id);
}
