package com.rpr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    public static Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topicPartitions = @TopicPartition(topic = "test-events",partitionOffsets = {
            @PartitionOffset(partition = "0",initialOffset = "0")
    }), containerFactory = "kafkaListenerContainerFactory")
    public void listenADifferentGrp(String msg){
        log.info("Message received from topic 1: {}",msg);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "test-events-2",partitionOffsets = {
            @PartitionOffset(partition = "0",initialOffset = "0")
    }), containerFactory = "kafkaListenerContainerFactory")
    public void listenEvent2(String msg){
        log.info("Message received from topic 2: {}",msg);
    }
}
