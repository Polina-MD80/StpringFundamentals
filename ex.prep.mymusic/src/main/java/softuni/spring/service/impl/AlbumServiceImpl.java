package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.AlbumEntity;
import softuni.spring.model.service.AlbumServiceModel;
import softuni.spring.model.view.AlbumViewModel;
import softuni.spring.repository.AlbumRepository;
import softuni.spring.service.AlbumService;
import softuni.spring.service.ArtistService;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, UserService userService, CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        AlbumEntity albumEntity = modelMapper.map(albumServiceModel, AlbumEntity.class);
        albumEntity.setAddedFrom(userService.findUserById(currentUser.getId()));
        albumEntity.setArtist(artistService.findArtistBy(albumServiceModel.getArtist()));

        albumRepository.save(albumEntity);

    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        return albumRepository.findAll().stream()
                .map(albumEntity -> modelMapper.map(albumEntity, AlbumViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public Integer totalCopies() {
        return albumRepository.findAll().stream()
                .mapToInt(AlbumEntity::getCopies)
                .reduce(Integer::sum).orElse(0);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
