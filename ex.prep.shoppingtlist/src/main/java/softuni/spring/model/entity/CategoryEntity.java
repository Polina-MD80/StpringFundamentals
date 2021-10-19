package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.CategoryName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<ProductEntity> products;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryName name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryEntity setName(CategoryName name) {
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
