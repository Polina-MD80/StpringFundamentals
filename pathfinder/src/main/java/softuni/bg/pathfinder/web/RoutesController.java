package softuni.bg.pathfinder.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.pathfinder.model.binding.RouteAddBindingModel;
import softuni.bg.pathfinder.model.service.RouteServiceModel;
import softuni.bg.pathfinder.service.RouteService;
import softuni.bg.pathfinder.util.CurrentUser;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("routes")
public class RoutesController {
  private final  RouteService routeService;
  private final CurrentUser currentUser;
  private final ModelMapper modelMapper;

    public RoutesController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("all")
    public String routes(Model model){
        model.addAttribute("routes", this.routeService.findAllRoutes());
        return "routes";
    }

    @GetMapping("details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("route", routeService.findRouteById(id));
        return "route-details";
    }

    @GetMapping("/add")
    public String addRoute(){
        if (!currentUser.isLoggedIn()){
            return "redirect:/";
        }

        return "add-route";
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel(){
        return new RouteAddBindingModel();
    }

    @PostMapping("/add")
    private String confAddRoute(@Valid RouteAddBindingModel routeAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("routeAddBindingModel",routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel", bindingResult);

            return "redirect:add";

        }
        RouteServiceModel routeServiceModel = modelMapper.map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

        routeService.addNewRoute(routeServiceModel);


        System.out.println("I am here");

        return "redirect:all";
    }

}
