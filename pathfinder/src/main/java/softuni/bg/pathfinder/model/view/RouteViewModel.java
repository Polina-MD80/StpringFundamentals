package softuni.bg.pathfinder.model.view;

import softuni.bg.pathfinder.model.entity.Category;
import softuni.bg.pathfinder.model.entity.Picture;
import softuni.bg.pathfinder.model.entity.User;
import softuni.bg.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

public class RouteViewModel {
    private Long id;
    private String description;
    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private User author;
    private Set<Category> categories;
    private Set<Picture> pictures;
    private Picture routeFirstPicture;

    public RouteViewModel() {
    }

    public Picture getRouteFirstPicture() {
        return routeFirstPicture;
    }

    public RouteViewModel setRouteFirstPicture(Picture routeFirstPicture) {
        this.routeFirstPicture = routeFirstPicture;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RouteViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteViewModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RouteViewModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteViewModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
