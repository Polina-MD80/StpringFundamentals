package softuni.bg.mobilelele.models.view;

import softuni.bg.mobilelele.models.enums.Engine;
import softuni.bg.mobilelele.models.enums.Transmission;

public class OfferSummaryView {
    private long id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private Integer price;
    private Transmission transmission;
    private Integer year;
    private String model;
    private String brand;
    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public OfferSummaryView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public OfferSummaryView setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSummaryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferSummaryView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferSummaryView setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferSummaryView setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSummaryView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferSummaryView setModel(String model) {
        this.model = model;
        return this;
    }
}
