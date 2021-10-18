package softuni.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.spring.model.entity.OrderEntity;
import softuni.spring.model.service.OrderServiceModel;
import softuni.spring.model.view.OrderViewModel;
import softuni.spring.repository.OrderRepository;
import softuni.spring.sec.CurrentUser;
import softuni.spring.service.CategoryService;
import softuni.spring.service.OrderService;
import softuni.spring.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);

        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByName(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderedByPriceDesc() {
        List<OrderEntity> allByOrderByPriceDesc = orderRepository.findAllByOrderByPriceDesc();
     return    allByOrderByPriceDesc.stream().map(orderEntity -> {
            OrderViewModel orderViewModel = modelMapper.map(orderEntity, OrderViewModel.class);
            orderViewModel.setNeededTime(orderEntity.getCategory().getTime());
            return orderViewModel;
        }).collect(Collectors.toList());

    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
