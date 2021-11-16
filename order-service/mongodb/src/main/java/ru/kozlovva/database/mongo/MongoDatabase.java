package ru.kozlovva.database.mongo;

import lombok.RequiredArgsConstructor;
import ru.kozlovva.port.order.database.Database;
import ru.kozlovva.port.order.database.OrderGateway;

@RequiredArgsConstructor
public class MongoDatabase implements Database {

    private final OrderGateway orderGateway;

    @Override
    public OrderGateway getOrderRepository() {
        return orderGateway;
    }
}
