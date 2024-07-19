package com.rpr;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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
        List<Integer> orderIds = new Random().ints(100, 1, 1000).distinct().limit(10).boxed().toList();
        List<String> itemList = Arrays.asList("Doll", "Book", "Pouch", "Jar", "Bottle", "HeadSet", "Glass", "Mug", "Bag", "Pillow");
        List<Double> priceList = new Random().doubles(100, 500, 5000).distinct().limit(10).boxed().toList();
        List<Integer> quantList = new Random().ints(100, 1, 100).distinct().limit(10).boxed().toList();
        IntStream.range(0,10).forEach(i->{
            Order order = createOrder(i, orderIds, itemList, priceList, quantList);
            log.info("New Order Created: {}",order.toString());
            orderTemplate.send(new ProducerRecord<>(topic,order));
            orderAckTopic(order.getOrderId());
        });

    }

    private Order createOrder(int i, List<Integer> orderIds, List<String> itemList, List<Double> priceList, List<Integer> quantList){
        return Order.builder().orderId(orderIds.get(i)).orderItem(itemList.get(i)).price(priceList.get(i)).quantity(quantList.get(i)).build();
    }

    private void orderAckTopic(int orderId){
        String ackStr = "Order with order id "+orderId+" is sent";
        ProducerRecord<String,String> record = new ProducerRecord<>(ackTopic,ackStr);
        strKafkaTemplate.send(record);
        log.info("Ack sent: {}",ackStr);
    }
}
