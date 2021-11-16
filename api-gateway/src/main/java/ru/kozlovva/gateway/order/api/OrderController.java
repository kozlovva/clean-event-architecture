package ru.kozlovva.gateway.order.api;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kozlovva.gateway.order.api.request.CreateOrderRequest;
import ru.kozlovva.gateway.order.kafka.CreateOrderCommand;
import ru.kozlovva.gateway.order.kafka.Topics;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public void createOrder(@RequestBody CreateOrderRequest request) {
        var message = MessageBuilder
                .withPayload(CreateOrderCommand.builder()
                        .customerId(request.getCustomerId())
                        .products(request.getProducts())
                        .build())
                .setHeader(KafkaHeaders.TOPIC, Topics.CREATE_ORDER)
                .build();
        kafkaTemplate.send(message);
    }

}
