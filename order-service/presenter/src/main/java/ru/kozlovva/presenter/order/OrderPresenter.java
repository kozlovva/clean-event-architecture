package ru.kozlovva.presenter.order;

import ru.kozlovva.entity.order.Order;
import ru.kozlovva.port.order.presenter.OrderOutputBoundary;
import ru.kozlovva.port.order.presenter.OrderViewModel;

import java.util.stream.Collectors;

public class OrderPresenter implements OrderOutputBoundary {

    private OrderViewModel orderViewModel;

    public OrderViewModel getViewModel() {
        return this.orderViewModel;
    }

    public void present(Order response) {
        this.orderViewModel = OrderViewModel.builder()
                .customerId(response.getCustomerId())
                .id(response.getId().toString())
                .status(response.getStatus().name())
                .totalPrice(response.getTotalPrice())
                .products(response.getProducts().stream()
                        .map(p -> new OrderViewModel.Product(p.getId(), p.getCount(), p.getPrice()))
                        .collect(Collectors.toList()))
                .build();
    }
}
