package softuni.bg.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.pathfinder.model.entity.Route;
import softuni.bg.pathfinder.model.service.RouteServiceModel;
import softuni.bg.pathfinder.repository.RouteRepository;
import softuni.bg.pathfinder.service.RouteService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteServiceModel> findAllRoutes() {
        List<Route> routes = this.routeRepository.findAll();
        return routes.stream().map(route -> modelMapper.map(route, RouteServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public RouteServiceModel findRouteById(Long id) {
        Route byId = this.routeRepository.findById(id).orElse(null);
        return modelMapper.map(byId, RouteServiceModel.class);
    }

}
