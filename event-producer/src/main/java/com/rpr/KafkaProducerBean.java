package com.rpr;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerBean {
    public final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducerBean(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Bean
    public NewTopic newTopic(){
        return new NewTopic(AppConstants.TOPIC_NAME,1,(short)1);
    }
}
