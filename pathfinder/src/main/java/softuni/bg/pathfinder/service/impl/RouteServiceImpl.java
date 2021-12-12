package softuni.bg.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.pathfinder.model.entity.Category;
import softuni.bg.pathfinder.model.entity.Picture;
import softuni.bg.pathfinder.model.entity.Route;
import softuni.bg.pathfinder.model.service.RouteServiceModel;
import softuni.bg.pathfinder.model.view.RouteViewModel;
import softuni.bg.pathfinder.repository.RouteRepository;
import softuni.bg.pathfinder.service.CategoryService;
import softuni.bg.pathfinder.service.RouteService;
import softuni.bg.pathfinder.service.UserService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutes() {
        List<Route> routes = this.routeRepository.findAll();
        return routes.stream().map(route ->{
            RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
            routeViewModel.setRouteFirstPicture(route.getPictures().stream().findAny().orElse(new Picture().setUrl("/images/pic4.jpg")));
            return routeViewModel;
        } ).collect(Collectors.toList());
    }

    @Override
    public RouteViewModel findRouteById(Long id) {
        Route byId = this.routeRepository.findById(id).orElse(null);
        return modelMapper.map(byId, RouteViewModel.class);
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel, Route.class);
        route.setAuthor(userService.findCurrentUserEntity());
        Set<Category> categories = routeServiceModel.getCategories().stream().map(categoryService::findByName).collect(Collectors.toSet());
        route.setCategories(categories);
        routeRepository.save(route);
    }

}
