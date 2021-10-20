package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.ArtistEnumName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ArtistEnumName name;
    @Column(columnDefinition = "TEXT")
    private String careerInformation;
    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private Set<AlbumEntity> albums;

    public ArtistEntity() {
    }

    public ArtistEntity(ArtistEnumName name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    public ArtistEnumName getName() {
        return name;
    }

    public ArtistEntity setName(ArtistEnumName name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
