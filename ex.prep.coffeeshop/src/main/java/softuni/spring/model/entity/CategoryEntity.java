package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(nullable = false)
    private Integer neededTime;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryName name, Integer time) {
        this.name = name;
        this.neededTime = time;
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryEntity setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public Integer getTime() {
        return neededTime;
    }

    public CategoryEntity setTime(Integer time) {
        this.neededTime = time;
        return this;
    }
}
