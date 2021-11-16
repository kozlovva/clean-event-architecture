package ru.kozlovva.demo.endpoint.order.createOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kozlovva.port.order.presenter.OrderOutputBoundary;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderCommand;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderInputBoundary;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final CreateOrderInputBoundary orderInputBoundary;
    private final OrderOutputBoundary orderOutputBoundary;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOrderCommand command) {
        orderInputBoundary.execute(command);
        return ResponseEntity.ok(orderOutputBoundary.getViewModel());
    }

}
