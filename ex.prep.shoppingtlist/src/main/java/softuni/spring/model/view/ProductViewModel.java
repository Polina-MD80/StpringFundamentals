package softuni.spring.model.view;

import softuni.spring.model.entity.CategoryEntity;

import java.math.BigDecimal;

public class ProductViewModel {
    private Long id;
    private String name;
    private CategoryEntity category;
    private BigDecimal price;

    public ProductViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ProductViewModel setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
