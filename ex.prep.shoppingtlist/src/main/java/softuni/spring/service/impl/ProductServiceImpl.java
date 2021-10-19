package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.ProductEntity;
import softuni.spring.model.entity.enums.CategoryName;
import softuni.spring.model.service.ProductServiceModel;
import softuni.spring.model.view.ProductViewModel;
import softuni.spring.repository.ProductRepository;
import softuni.spring.service.CategoryService;
import softuni.spring.service.ProductService;

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
