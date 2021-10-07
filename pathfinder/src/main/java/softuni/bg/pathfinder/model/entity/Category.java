package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }
}
