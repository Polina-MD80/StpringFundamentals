package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.CategoryEntity;
import softuni.spring.model.entity.ShipEntity;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.service.ShipServiceModel;
import softuni.spring.model.view.ShipViewModel;
import softuni.spring.repository.ShipRepository;
import softuni.spring.service.CategoryService;
import softuni.spring.service.ShipService;
import softuni.spring.service.UserService;
import softuni.spring.user.CurrentUser;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;


    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public boolean addShip(ShipServiceModel shipServiceModel) {

        ShipEntity shipEntity = modelMapper.map(shipServiceModel, ShipEntity.class);
        CategoryEntity categoryEntity = categoryService.findBuCategoryEnumName(shipServiceModel.getCategory()).orElse(null);
        UserEntity userEntity = userService.findById(currentUser.getId());

        if (userEntity != null && categoryEntity != null) {
            shipEntity.setCategory(categoryEntity);
            shipEntity.setUser(userEntity);
        }

        try {
            shipRepository.save(shipEntity);
        } catch (Exception e) {
            return false;
        }
        return true;


    }

    @Override
    public List<ShipViewModel> findAllShips() {
        List<ShipEntity> ships = shipRepository.findAll();
        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findByUser(Long id) {
        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUser(user);

        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findByUserNot(Long id) {
        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUserNot(user);

        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(String ship1,String ship2) {
        ShipEntity attacker = shipRepository.findByName(ship1);
        ShipEntity defender = shipRepository.findByName(ship2);

        if (attacker!=null&&defender!=null){
            Integer power = attacker.getPower();
            Integer health = defender.getHealth();
            if(health-power <= 0){
                shipRepository.delete(defender);
            }else {
                defender.setHealth(health-power);
                shipRepository.save(defender);
            }

        }



    }
}
