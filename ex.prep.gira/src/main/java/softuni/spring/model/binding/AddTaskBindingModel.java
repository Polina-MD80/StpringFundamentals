package softuni.spring.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring.model.entity.enums.ClassificationNameEnum;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class AddTaskBindingModel {
    @NotBlank
    @Size(min=3, max = 20, message = "Name length must be between 3 and 20 characters ")
    private String name;
    @NotBlank
    @Size(min = 5, message = "Description min length must be minimum 5")
    private String description;
    @FutureOrPresent(message = "Date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotNull(message = "Classification cannot be null")
    private ClassificationNameEnum classification;

    public AddTaskBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddTaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddTaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public AddTaskBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
