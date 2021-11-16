package ru.kozlovva.kafka.order.payload;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.kozlovva.kafka.order.dto.OrderDTO;

@SuperBuilder
@Getter
public class OrderCreatedEvent{
    private OrderDTO order;

    public static OrderCreatedEvent of(OrderDTO order) {
        return OrderCreatedEvent.builder()
                .order(order)
                .build();
    }
}
