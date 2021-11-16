package ru.kozlovva.kafka.order.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kozlovva.port.order.presenter.OrderViewModel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderCommand {
    private String customerId;
    private List<OrderViewModel.Product> products;
}
