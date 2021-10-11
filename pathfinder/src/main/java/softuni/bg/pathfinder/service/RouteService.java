package softuni.bg.pathfinder.service;

import softuni.bg.pathfinder.model.service.RouteServiceModel;

import java.util.List;

public interface RouteService {
    List<RouteServiceModel> findAllRoutes();


    RouteServiceModel findRouteById(Long id);
}
