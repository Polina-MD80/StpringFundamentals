package softuni.spring.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring.model.entity.enums.CategoryName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductBindingModel {
    @NotEmpty
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    private String name;
    @NotEmpty
    @Size(min = 5, message = "Description min length must be minimum 5 characters")
    private String description;
    @FutureOrPresent(message = "Date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;
    @PositiveOrZero(message = "Price cannot be negative")
    private BigDecimal price;
    @NotNull(message = "Choose category")
    private CategoryName category;

    public ProductBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ProductBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
