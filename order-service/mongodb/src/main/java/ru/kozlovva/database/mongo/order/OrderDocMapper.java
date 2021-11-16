package ru.kozlovva.database.mongo.order;

import ru.kozlovva.entity.order.Order;

import java.util.UUID;

public class OrderDocMapper {

    public static OrderDoc map(Order order) {
        return OrderDoc.builder()
                .id(order.getId().toString())
                .cancelAt(order.getCancelAt())
                .createdAt(order.getCreatedAt())
                .customerId(order.getCustomerId())
                .endAt(order.getEndAt())
                .products(order.getProducts())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .build();
    }


    public static Order inverseMap(OrderDoc order) {
        return new Order(
                UUID.fromString(order.getId()),
                order.getStatus(),
                order.getCustomerId(),
                order.getProducts(),
                order.getCreatedAt(),
                order.getCancelAt(),
                order.getStartAt(),
                order.getEndAt(),
                order.getTotalPrice()
        );
    }

}
