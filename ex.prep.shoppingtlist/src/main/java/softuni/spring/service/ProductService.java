package softuni.spring.service;

import softuni.spring.model.entity.enums.CategoryName;
import softuni.spring.model.service.ProductServiceModel;
import softuni.spring.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);
    List<ProductViewModel> findAllProducts();

    BigDecimal totalSum();

    List<ProductViewModel> findByCategoryName(CategoryName categoryName);

    void buy(Long id);

    void buyAll();

}
