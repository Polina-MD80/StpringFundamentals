package softuny.my_retake_exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import softuny.my_retake_exam.model.binding.ProductBindingModel;

import softuny.my_retake_exam.model.service.ProductServiceModel;
import softuny.my_retake_exam.service.ProductService;
import softuny.my_retake_exam.user.CurrentUser;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add() {
        if (currentUser.getId()==null){
            return "redirect:/users/login";
        }
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
        if (currentUser.getId()==null){
            return "redirect:/users/login";
        }
        productService.buy(id);
        return "redirect:/";
    }

    @GetMapping("buy/all")
    public String buyAll() {
        if (currentUser.getId()==null){
            return "redirect:/users/login";
        }
        productService.buyAll();
        return "redirect:/";
    }
}
