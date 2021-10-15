package softuni.bg.mobilelele.models.service;

import softuni.bg.mobilelele.models.binding.OfferUpdateBindingModel;
import softuni.bg.mobilelele.models.enums.Engine;
import softuni.bg.mobilelele.models.enums.Transmission;

public class OfferUpdateServiceModel {
    private String description;

    private Engine engine;

    private String imageUrl;

    private int mileage;

    private int price;

    private Transmission transmission;

    private int year;

    private Long id;

    public String getDescription() {
        return description;
    }

    public OfferUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferUpdateServiceModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferUpdateServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferUpdateServiceModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdateServiceModel setYear(int year) {
        this.year = year;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
