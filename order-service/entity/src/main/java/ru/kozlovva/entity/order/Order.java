package ru.kozlovva.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Order {
    private UUID id;
    private Status status;
    private String customerId;
    private List<Product> products;
    private Instant createdAt;
    private Instant cancelAt;
    private Instant startAt;
    private Instant endAt;
    private BigDecimal totalPrice;

    public Order(UUID id, String customerId, List<Product> products) {
        this.id = id;
        this.status = Status.NEW;
        this.customerId = customerId;
        this.products = products;
        this.totalPrice = calcTotal(products);
        this.createdAt = Instant.now();
    }

    public enum Status {
        NEW, COMPLETED, CANCELLED, IN_PROGRESS
    }


    @AllArgsConstructor
    @Getter
    public static class Product {
        private String id;
        private Long count;
        private BigDecimal price;

        public BigDecimal calcTotal() {
            return price.multiply(BigDecimal.valueOf(count));
        }
    }

    public void complete(Instant completeDate) {
        this.status = Status.COMPLETED;
        this.endAt = completeDate;
    }

    public void startDelivery(Instant startDate) {
        this.status = Status.IN_PROGRESS;
        this.startAt = Objects.requireNonNullElse(startDate, Instant.now());
    }

    public void cancel(Instant cancelDate) {
        this.status = Status.CANCELLED;
        this.cancelAt = Objects.requireNonNullElse(cancelDate, Instant.now());
    }

    private static BigDecimal calcTotal(List<Product> products) {
        return products.stream().map(Product::calcTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
