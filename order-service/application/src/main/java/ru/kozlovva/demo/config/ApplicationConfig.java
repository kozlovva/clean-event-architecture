package ru.kozlovva.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import ru.kozlovva.core.DefaultEventDispatcher;
import ru.kozlovva.core.EventDispatcher;
import ru.kozlovva.database.mongo.MongoDatabase;
import ru.kozlovva.entity.order.event.OrderCreatedEvent;
import ru.kozlovva.kafka.order.handler.OrderCreatedHandler;
import ru.kozlovva.port.order.database.Database;
import ru.kozlovva.port.order.database.OrderGateway;
import ru.kozlovva.port.order.presenter.OrderOutputBoundary;
import ru.kozlovva.port.order.usecase.createOrder.CreateOrderInputBoundary;
import ru.kozlovva.presenter.order.OrderPresenter;
import ru.kozlovva.usecase.order.CreateOrder;

@Configuration
public class ApplicationConfig {

    @Bean
    public Database database(OrderGateway orderGateway) {
        return new MongoDatabase(orderGateway);
    }

    @Bean
    public CreateOrderInputBoundary createOrderInputBoundary(Database database, OrderOutputBoundary orderOutputBoundary, EventDispatcher eventDispatcher) {
        return new CreateOrder(database.getOrderRepository(), orderOutputBoundary, eventDispatcher);
    }

    @Bean
    public OrderOutputBoundary orderOutputBoundary() {
        return new OrderPresenter();
    }

    @Bean
    public EventDispatcher eventDispatcher(OrderCreatedHandler orderCreatedHandler) {
        var eventDispatcher = new DefaultEventDispatcher();
        eventDispatcher.registerHandler(OrderCreatedEvent.class, orderCreatedHandler);
        return eventDispatcher;
    }
}
