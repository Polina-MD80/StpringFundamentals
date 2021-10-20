package softuni.spring.model.service;

import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.entity.enums.ArtistEnumName;
import softuni.spring.model.entity.enums.GenreEnumName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlbumServiceModel {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private GenreEnumName genre;
    private Integer copies;
    private BigDecimal price;
    private String producer;
    private LocalDate releaseDate;
    private ArtistEnumName artist;
    private UserEntity addedFrom;

    public AlbumServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public GenreEnumName getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(GenreEnumName genre) {
        this.genre = genre;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumServiceModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public ArtistEnumName getArtist() {
        return artist;
    }

    public AlbumServiceModel setArtist(ArtistEnumName artist) {
        this.artist = artist;
        return this;
    }

    public UserEntity getAddedFrom() {
        return addedFrom;
    }

    public AlbumServiceModel setAddedFrom(UserEntity addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
