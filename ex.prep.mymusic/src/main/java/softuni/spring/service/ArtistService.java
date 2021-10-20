package softuni.spring.service;

import softuni.spring.model.entity.ArtistEntity;
import softuni.spring.model.entity.enums.ArtistEnumName;

public interface ArtistService {
    void initializeArtists();


    ArtistEntity findArtistBy(ArtistEnumName artist);
}
