package ru.kozlovva.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import ru.kozlovva.kafka.order.ProducerTopics;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder
                .name(ProducerTopics.ORDER_CREATED)
                .build();
    }

}
