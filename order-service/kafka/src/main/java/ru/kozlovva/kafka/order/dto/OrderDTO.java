package ru.kozlovva.kafka.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class OrderDTO {
    private String id;
    private String status;
    private String customerId;
    private List<Product> products;
    private Instant createdAt;
    private Instant cancelAt;
    private Instant startAt;
    private Instant endAt;
    private BigDecimal totalPrice;

    @AllArgsConstructor
    @Getter
    public static class Product {
        private String id;
        private Long count;
        private BigDecimal price;
    }
}
