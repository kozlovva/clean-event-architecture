package ru.kozlovva.database.mongo.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kozlovva.entity.order.Order;
import ru.kozlovva.port.order.database.OrderGateway;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MongoOrderGateway implements OrderGateway {

    private final OrderRepository orderRepository;

    public Order save(Order order) {
        orderRepository.save(OrderDocMapper.map(order));
        return order;
    }

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id)
                .map(OrderDocMapper::inverseMap);
    }
}
