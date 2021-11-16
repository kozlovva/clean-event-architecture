package ru.kozlovva.kafka.order.mapper;

import ru.kozlovva.entity.order.Order;
import ru.kozlovva.kafka.order.dto.OrderDTO;

import java.util.stream.Collectors;

public class OrderDTOMapper {

    public static OrderDTO map(Order order) {
        return OrderDTO.builder()
                .id(order.getId().toString())
                .status(order.getStatus().name())
                .cancelAt(order.getCancelAt())
                .createdAt(order.getCreatedAt())
                .customerId(order.getCustomerId())
                .endAt(order.getEndAt())
                .totalPrice(order.getTotalPrice())
                .products(order.getProducts()
                        .stream()
                        .map(p -> new OrderDTO.Product(p.getId(), p.getCount(), p.getPrice()))
                        .collect(Collectors.toList()))
                .build();
    }

}
