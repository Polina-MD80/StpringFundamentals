package softuni.bg.mobilelele.models.binding;

import softuni.bg.mobilelele.models.enums.Engine;
import softuni.bg.mobilelele.models.enums.Transmission;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


public class OfferUpdateBindingModel {
    private String description;
    @NotNull
    private Engine engine;

    private String imageUrl;
    @NotNull
    @PositiveOrZero
    private int mileage;
    @Positive
    private int price;
    @NotNull
    private Transmission transmission;
    @Max(2021)
    private int year;

    private Long id;

    public String getDescription() {
        return description;
    }

    public OfferUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferUpdateBindingModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferUpdateBindingModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferUpdateBindingModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferUpdateBindingModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdateBindingModel setYear(int year) {
        this.year = year;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }
}
