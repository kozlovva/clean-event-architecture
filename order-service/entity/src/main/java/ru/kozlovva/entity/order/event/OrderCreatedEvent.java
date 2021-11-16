package ru.kozlovva.entity.order.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.kozlovva.core.AbstractEvent;
import ru.kozlovva.entity.order.Order;

@RequiredArgsConstructor
@Getter
public class OrderCreatedEvent extends AbstractEvent {
    private final Order order;
}
