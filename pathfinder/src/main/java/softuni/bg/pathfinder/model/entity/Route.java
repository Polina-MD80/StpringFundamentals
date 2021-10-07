package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private String videoUrl;

    @ManyToOne
    private User author;
    @ManyToMany
    private Set<Category> categories;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
