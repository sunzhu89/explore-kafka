package com.rpr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {
    public static Logger log = LoggerFactory.getLogger(OrderConsumerService.class);

    @KafkaListener(topics = Constants.ORDER_TOPIC, groupId = Constants.ORDER_GROUP, containerFactory = "orderListenerFactory")
    public void listenOrderGroup(Order order) {
        log.info("Order received: {}", order.toString());
    }

    @KafkaListener(topics = Constants.ACK_TOPIC , groupId = Constants.ACK_GROUP, containerFactory = "ackListenerFactory")
    public void listenAckGroup(String ack) {
        log.info("Order Ack received: {}",ack);
    }
}
