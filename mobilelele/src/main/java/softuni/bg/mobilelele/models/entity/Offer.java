package softuni.bg.mobilelele.models.entity;

import softuni.bg.mobilelele.models.entity.enums.Engine;
import softuni.bg.mobilelele.models.entity.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

//•	description – some text.
//            •	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
//            •	imageUrl – the url of image.
//            •	mileage – a number.
//            •	price – the price of the offer.
//•	transmission – enumerated value (MANUAL, AUTOMATIC).
//            •	year – the year of offered car.
//•	created – a date and time.
//            •	modified – a date and time.
//            •	model – the model of a car.
//•	seller – a user that sells the car.
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated
    private Engine engine;
    @Column
    private String imageUrl;
    @Column
    private BigDecimal price;
    @Column
    private Integer mileage;
    @Enumerated
    private Transmission transmission;
    @Column
    private Instant created;
    @OneToOne
    private Model model;
    @ManyToOne
    private User seller;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
