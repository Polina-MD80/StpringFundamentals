package softuni.spring.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring.model.binding.BattleBindingModel;
import softuni.spring.model.binding.ShipAddBindingModel;
import softuni.spring.model.service.ShipServiceModel;
import softuni.spring.service.ShipService;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipsController {

    private final ModelMapper modelMapper;
    private final ShipService shipService;

    public ShipsController(ModelMapper modelMapper, ShipService shipService) {
        this.modelMapper = modelMapper;
        this.shipService = shipService;
    }

    @GetMapping("add")
    public String add(){
        return "ship-add";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
    @PostMapping("add")
    public String confAdd(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";
        }

        ShipServiceModel shipServiceModel = modelMapper.map(shipAddBindingModel, ShipServiceModel.class);

        boolean success = shipService.addShip(shipServiceModel);

        if (!success){
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("shipNameOccupied", true);
            return "redirect:add";
        }


        return "redirect:/";


    }






}
