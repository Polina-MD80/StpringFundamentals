package softuni.bg.pathfinder.model.entity;

import softuni.bg.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
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
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    public Route() {
    }

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

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Route setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
