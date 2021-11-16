package ru.kozlovva.gateway.order.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class CreateOrderRequest {
    private String customerId;
    private List<Product> products;

    @Builder
    @Getter
    public static class Product {
        private String id;
        private BigDecimal price;
        private Long count;
    }
}
