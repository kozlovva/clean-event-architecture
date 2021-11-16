package ru.kozlovva.kafka.order.handler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ru.kozlovva.core.EventHandler;
import ru.kozlovva.kafka.order.ProducerTopics;
import ru.kozlovva.kafka.order.mapper.OrderDTOMapper;
import ru.kozlovva.kafka.order.payload.OrderCreatedEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler implements EventHandler<ru.kozlovva.entity.order.event.OrderCreatedEvent> {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void onEvent(ru.kozlovva.entity.order.event.OrderCreatedEvent event) {
        try {
            var message = MessageBuilder
                    .withPayload(OrderCreatedEvent.of(OrderDTOMapper.map(event.getOrder())))
                    .setHeader(KafkaHeaders.TOPIC, ProducerTopics.ORDER_CREATED)
                    .build();
            kafkaTemplate.send(message);
            log.info("Message {} sent successfully", message.toString());
        } catch (Exception e) {
            log.error("Message not sent", e);
        }
    }
}
