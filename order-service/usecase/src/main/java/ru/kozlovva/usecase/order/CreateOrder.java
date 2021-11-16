package ru.kozlovva.usecase.order;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.core.EventDispatcher;
import ru.kozlovva.entity.order.Order;
import ru.kozlovva.entity.order.event.OrderCreatedEvent;
import ru.kozlovva.port.order.database.OrderGateway;
import ru.kozlovva.port.order.presenter.OrderOutputBoundary;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderCommand;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderInputBoundary;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateOrder implements CreateOrderInputBoundary {

    private final OrderGateway gateway;
    private final OrderOutputBoundary presenter;
    private final EventDispatcher eventDispatcher;

    public void execute(CreateOrderCommand input) {
        var order = new Order(
                UUID.randomUUID(),
                input.getCustomerId(),
                input.getProducts()
                        .stream()
                        .map(p -> new Order.Product(p.getId(), p.getCount(), p.getPrice()))
                        .collect(Collectors.toList())
        );

        gateway.save(order);
        eventDispatcher.dispatch(new OrderCreatedEvent(order));
        presenter.present(order);
    }
}
