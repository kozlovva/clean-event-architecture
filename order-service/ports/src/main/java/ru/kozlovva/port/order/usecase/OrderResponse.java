package ru.kozlovva.port.order.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.kozlovva.port.order.presenter.OrderViewModel;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class OrderResponse {
    private String id;
    private String status;
    private String customerId;
    private List<OrderViewModel.Product> products;
    private BigDecimal totalPrice;
    private OrderViewModel.TimeInfo timeInfo;

    @Builder
    @Getter
    public static class TimeInfo {
        private Instant createdAt;
        private Instant cancelAt;
        private Instant startAt;
        private Instant endAt;
    }

    @Builder
    @Getter
    public static class Product {
        private String id;
        private Long count;
    }
}
