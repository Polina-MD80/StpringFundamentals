package softuni.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.spring.model.entity.enums.CategoryName;
import softuni.spring.service.CategoryService;
import softuni.spring.service.ProductService;
import softuni.spring.user.CurrentUser;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ProductService productService;
    private final CategoryService categoryService;


    public HomeController(CurrentUser currentUser, ProductService productService, CategoryService categoryService) {
        this.currentUser = currentUser;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        //ToDo model.addAttributes()
        model.addAttribute("productViewModel", productService.findAllProducts());
        model.addAttribute("totalSum", productService.totalSum());

        model.addAttribute("drink", productService.findByCategoryName(CategoryName.DRINK));
        model.addAttribute("food", productService.findByCategoryName(CategoryName.FOOD));
        model.addAttribute("other", productService.findByCategoryName(CategoryName.OTHER));
        model.addAttribute("households", productService.findByCategoryName(CategoryName.HOUSEHOLD));

        return "home";
    }
}
