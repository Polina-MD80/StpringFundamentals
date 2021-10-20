package softuni.spring.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.spring.service.ArtistService;

@Component
public class InitDataBase implements CommandLineRunner {
    private final ArtistService artistService;

    public InitDataBase(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        artistService.initializeArtists();
    }
}
