package ru.kozlovva.kafka.order.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.kozlovva.kafka.order.ConsumerTopics;
import ru.kozlovva.kafka.order.payload.CreateOrderCommand;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderInputBoundary;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderEventListener {

    private final CreateOrderInputBoundary orderInputBoundary;

    @KafkaListener(topics = ConsumerTopics.CREATE_ORDER)
    public void listenCreateOrderCommand(CreateOrderCommand command) {
        try {
            orderInputBoundary.execute(ru.kozlovva.port.order.usecase.createOrder.CreateOrderCommand.builder()
                    .customerId(command.getCustomerId())
                    .products(command.getProducts())
                    .build());
        } catch (Exception e) {
            log.error("Create order processing error", e);
        }
    };
}
