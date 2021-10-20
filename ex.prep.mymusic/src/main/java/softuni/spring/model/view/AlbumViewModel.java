package softuni.spring.model.view;

import softuni.spring.model.entity.ArtistEntity;
import softuni.spring.model.entity.enums.ArtistEnumName;
import softuni.spring.model.entity.enums.GenreEnumName;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private GenreEnumName genre;
    private Integer copies;
    private BigDecimal price;
    private String producer;
    private LocalDate releaseDate;
    private ArtistEntity artist;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public GenreEnumName getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(GenreEnumName genre) {
        this.genre = genre;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumViewModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(ArtistEntity artist) {
        this.artist = artist;
        return this;
    }
}
