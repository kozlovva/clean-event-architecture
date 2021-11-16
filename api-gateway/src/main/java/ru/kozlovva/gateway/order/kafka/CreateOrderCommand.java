package ru.kozlovva.gateway.order.kafka;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kozlovva.gateway.order.api.request.CreateOrderRequest;

import java.util.List;

@Builder
@Getter
public class CreateOrderCommand {
    private String customerId;
    private List<CreateOrderRequest.Product> products;
}
