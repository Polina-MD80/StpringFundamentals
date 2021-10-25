package softuni.bg.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public User getAuthor() {
        return author;
    }

    public Picture setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getUser() {
        return author;
    }

    public void setUser(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
