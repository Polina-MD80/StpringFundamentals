package softuni.spring.service;

import softuni.spring.model.service.OrderServiceModel;
import softuni.spring.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderedByPriceDesc();

    void deleteOrderById(Long id);
}
