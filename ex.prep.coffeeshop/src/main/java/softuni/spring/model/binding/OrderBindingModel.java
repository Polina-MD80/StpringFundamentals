package softuni.spring.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring.model.entity.enums.CategoryName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderBindingModel {
    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;
    @NotNull
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @PastOrPresent(message = "Order time cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;
    @NotNull
    private CategoryName category;
    @NotBlank
    @Size(min = 5)
    private String description;

    public OrderBindingModel() {
    }

    public String getName() {
        return name;
    }

    public OrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public OrderBindingModel setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public OrderBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
