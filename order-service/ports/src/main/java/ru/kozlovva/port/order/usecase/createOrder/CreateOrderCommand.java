package ru.kozlovva.port.order.usecase.createOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.kozlovva.port.order.presenter.OrderViewModel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CreateOrderCommand {
    private String customerId;
    private List<OrderViewModel.Product> products;
}
