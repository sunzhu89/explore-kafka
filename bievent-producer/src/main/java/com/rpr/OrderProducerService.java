package com.rpr;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {
    public static Logger log = LoggerFactory.getLogger(OrderProducerService.class);

    @Value("${app.topic}")
    private String topic;

    @Value("${app.ackTopic}")
    private String ackTopic;

    @Autowired
    public KafkaTemplate<String, Order> orderTemplate;

    @Autowired
    public KafkaTemplate<String,String> strKafkaTemplate;

    public void createOrders() {
        log.info("App Topic {}",topic);
        OrderReader.getOrderList().forEach(order->{
            log.info("New Order Created: {}",order.toString());
            orderTemplate.send(new ProducerRecord<>(topic,order));
            orderAckTopic(order.getOrderId());
        });
    }

    private void orderAckTopic(int orderId){
        String ackStr = "Order with order id "+orderId+" is sent";
        ProducerRecord<String,String> record = new ProducerRecord<>(ackTopic,ackStr);
        strKafkaTemplate.send(record);
        log.info("Ack sent: {}",ackStr);
    }
}
