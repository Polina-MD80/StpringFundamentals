package softuny.my_retake_exam.service;



import softuny.my_retake_exam.model.entity.enums.CategoryName;
import softuny.my_retake_exam.model.service.ProductServiceModel;

import softuny.my_retake_exam.model.view.ProductViewModel;

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
