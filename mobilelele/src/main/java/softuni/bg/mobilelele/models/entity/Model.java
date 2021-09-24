package softuni.bg.mobilelele.models.entity;

import softuni.bg.mobilelele.models.entity.enums.Category;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Enumerated
    private Category category;
    @Column(length = 512)
    private  String imageUrl;
    @Column
    private Integer startYear;
    @Column
    private Integer endYear;
    @Column
    private Instant created;
    @Column
    private Instant modified;
    @ManyToOne
    private Brand brand;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
