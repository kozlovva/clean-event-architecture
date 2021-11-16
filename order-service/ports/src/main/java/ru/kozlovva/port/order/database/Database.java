package ru.kozlovva.port.order.database;

public interface Database {
    OrderGateway getOrderRepository();
}
