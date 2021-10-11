package softuni.bg.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RoutesController {
  private final  RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String routes(Model model){
        model.addAttribute("routes", this.routeService.findAllRoutes());
        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("route", routeService.findRouteById(id));
        return "route-details";
    }


}
