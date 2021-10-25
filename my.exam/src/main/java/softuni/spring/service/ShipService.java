package softuni.spring.service;

import softuni.spring.model.entity.ShipEntity;
import softuni.spring.model.service.ShipServiceModel;
import softuni.spring.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    boolean addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShips();

    List<ShipViewModel> findByUser(Long id);

    List<ShipViewModel> findByUserNot(Long id);

    void fire(String ship1, String ship2);
}
