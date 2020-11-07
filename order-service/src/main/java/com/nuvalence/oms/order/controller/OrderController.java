package com.nuvalence.oms.order.controller;

import com.nuvalence.oms.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public static final String TOPIC_NAME = "order-topic";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public OrderController(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("order/{sku}")
    public ResponseEntity<Void> sendOrder(@PathVariable("sku") String sku) {
        logger.info("test");
        Order order = new Order();
        order.setSku(sku);
        order.setQuantity(1);

        kafkaTemplate.send(TOPIC_NAME, order);

        logger.info("Sent order to kafka: {}", order.toString());

        return ResponseEntity.noContent().build();
    }
}
