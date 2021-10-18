package softuni.spring.model.service;

import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.entity.enums.CategoryName;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String name;

    private BigDecimal price;

    private LocalDateTime time;

    private CategoryName category;

    private String description;

    private UserEntity employee;

    public OrderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public OrderServiceModel setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderServiceModel setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
