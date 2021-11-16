package ru.kozlovva.port.order.presenter;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderViewModel {
    private String id;
    private String status;
    private String customerId;
    private List<Product> products;
    private BigDecimal totalPrice;
    private TimeInfo timeInfo;

    @Builder
    @Getter
    public static class TimeInfo {
        private Instant createdAt;
        private Instant cancelAt;
        private Instant startAt;
        private Instant endAt;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Product {
        private String id;
        private Long count;
        private BigDecimal price;
    }
}
