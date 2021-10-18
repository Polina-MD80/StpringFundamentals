package softuni.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.spring.model.view.OrderViewModel;
import softuni.spring.model.view.UserViewModel;
import softuni.spring.sec.CurrentUser;
import softuni.spring.service.OrderService;
import softuni.spring.service.UserService;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        List<OrderViewModel> orders = orderService.findAllOrdersOrderedByPriceDesc();
        Integer sum = orders.stream().map(OrderViewModel::getNeededTime).reduce(Integer::sum).orElse(0);
        List<UserViewModel> users = userService.findAllUsersByCountOfOrdersDesc();
        model.addAttribute("orders", orders);
        model.addAttribute("users", users);
        model.addAttribute("totalTime", sum);
        return "home";
    }

}
