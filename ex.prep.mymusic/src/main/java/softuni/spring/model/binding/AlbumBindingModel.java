package softuni.spring.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring.model.entity.ArtistEntity;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.entity.enums.ArtistEnumName;
import softuni.spring.model.entity.enums.GenreEnumName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlbumBindingModel {
    @NotBlank
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    private String name;
    @NotBlank
    @Size(min = 5, message = "Description min length must be minimum 5")
    private String description;
    @NotBlank
    @Size(min = 5, message = "Image Url length must be minimum 5")
    private String imageUrl;
    @NotNull(message = "You must select genre")
    private GenreEnumName genre;

    @Min(message = "Must be a more than 10", value = 10)
    private Integer copies;
    @Positive
    @NotNull
    private BigDecimal price;
    private String producer;
    @PastOrPresent(message = "Date that cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotNull(message = "You must select artist")
    private ArtistEnumName artist;

    public AlbumBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public GenreEnumName getGenre() {
        return genre;
    }

    public AlbumBindingModel setGenre(GenreEnumName genre) {
        this.genre = genre;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public ArtistEnumName getArtist() {
        return artist;
    }

    public AlbumBindingModel setArtist(ArtistEnumName artist) {
        this.artist = artist;
        return this;
    }
}
