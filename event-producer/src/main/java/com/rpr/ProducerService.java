package com.rpr;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(AppConstants.TOPIC_NAME, message);
        kafkaTemplate.send(producerRecord);
    }

}
