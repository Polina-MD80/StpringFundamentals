package softuni.spring.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring.model.binding.OrderBindingModel;
import softuni.spring.model.service.OrderServiceModel;
import softuni.spring.service.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add")
    public String add(){
        return "order-add";
    }

    @ModelAttribute
    public OrderBindingModel orderBindingModel(){
        return new OrderBindingModel();
    }

    @PostMapping("add")
    public String confAdd(@Valid OrderBindingModel orderBindingModel,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderBindingModel",orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel", bindingResult);

            return "redirect:add";
        }

        OrderServiceModel orderServiceModel = modelMapper.map(orderBindingModel, OrderServiceModel.class);

        orderService.addOrder(orderServiceModel);


        return "redirect:/";

    }
    @GetMapping("ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.deleteOrderById(id);
        return "redirect:/";
    }

}
