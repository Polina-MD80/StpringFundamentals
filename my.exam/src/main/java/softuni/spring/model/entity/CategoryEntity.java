package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{
    @Enumerated
    @Column(nullable = false, unique = true)
    private CategoryNameEnum name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
