package softuni.bg.mobilelele.models.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private Instant created;
    @Column
    private Instant modified;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;
    public Brand() {
    }

    public List<Model> getModels() {
        return models;
    }

    public Brand setModels(List<Model> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
