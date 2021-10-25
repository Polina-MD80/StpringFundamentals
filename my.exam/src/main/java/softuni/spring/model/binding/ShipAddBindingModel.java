package softuni.spring.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring.model.entity.enums.CategoryNameEnum;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {
    @NotBlank
    @Size(min = 2, max = 10, message = "The name must be between 2 and 10 characters")
    private String name;
    @Positive(message = "The power must be positive")
    @NotNull
    private Integer power;
    @Positive(message = "The health must be positive")
    @NotNull
    private Integer health;
    @NotNull
    @PastOrPresent(message = "Created date can not be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    @NotNull(message = "You must select a category")
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
