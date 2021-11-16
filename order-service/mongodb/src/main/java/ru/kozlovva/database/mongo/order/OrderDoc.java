package ru.kozlovva.database.mongo.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.kozlovva.entity.order.Order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document
public class OrderDoc {
    @Id
    private String id;
    @Indexed
    private Order.Status status;
    @Indexed
    private String customerId;
    private List<Order.Product> products;
    private Instant createdAt;
    private Instant cancelAt;
    private Instant startAt;
    private Instant endAt;
    private BigDecimal totalPrice;
}
