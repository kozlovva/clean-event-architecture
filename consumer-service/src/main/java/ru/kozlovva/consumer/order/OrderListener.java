package ru.kozlovva.consumer.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class OrderListener {

    @KafkaListener(topics = Topics.ORDER_CREATED)
    public void listenOrderCreated(Map<String, Object> payload) {
        log.info("Order created event {}", payload.toString());
    }

}
