package softuny.my_retake_exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuny.my_retake_exam.model.entity.ProductEntity;
import softuny.my_retake_exam.model.entity.enums.CategoryName;
import softuny.my_retake_exam.model.service.ProductServiceModel;

import softuny.my_retake_exam.model.view.ProductViewModel;
import softuny.my_retake_exam.repository.ProductRepository;
import softuny.my_retake_exam.service.CategoryService;
import softuny.my_retake_exam.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        productEntity.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(productEntity);
    }

    @Override
    public List<ProductViewModel> findAllProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        return productEntityList.stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalSum() {
        return this.findAllProducts().stream()
                .map(ProductViewModel::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public List<ProductViewModel> findByCategoryName(CategoryName categoryName) {
        List<ProductEntity> byCategory_name = productRepository.findByCategory_Name(categoryName);
        return byCategory_name.stream().map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
