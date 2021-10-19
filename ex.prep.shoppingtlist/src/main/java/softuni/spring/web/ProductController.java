package softuni.spring.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.spring.model.binding.ProductBindingModel;
import softuni.spring.model.service.ProductServiceModel;
import softuni.spring.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add() {
        return "product-add";
    }

    @ModelAttribute
    public ProductBindingModel productBindingModel() {
        return new ProductBindingModel();
    }

    @PostMapping("add")
    public String addConfirm(@Valid ProductBindingModel productBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel", bindingResult);


            return "redirect:add";
        }

        ProductServiceModel productServiceModel = modelMapper.map(productBindingModel, ProductServiceModel.class);
        productService.add(productServiceModel);


        return "redirect:/";

    }

    @GetMapping("buy/{id}")
    public String buy(@PathVariable Long id) {
        productService.buy(id);
        return "redirect:/";
    }

    @GetMapping("buy/all")
    public String buyAll() {
        productService.buyAll();
        return "redirect:/";
    }
}
