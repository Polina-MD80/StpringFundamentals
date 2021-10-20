package softuni.spring.service;

import softuni.spring.model.service.AlbumServiceModel;
import softuni.spring.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbums();

    Integer totalCopies();

    void delete(Long id);
}
