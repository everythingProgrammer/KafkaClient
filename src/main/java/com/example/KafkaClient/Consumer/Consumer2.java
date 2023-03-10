package com.example.KafkaClient.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 implements AcknowledgingMessageListener {

private int counter = 0;

    Logger logger = LogManager.getLogger(Consumer2.class);
    @Override
    @KafkaListener(topics="custom_topic_1")
    public void onMessage(ConsumerRecord consumerRecord, Acknowledgment acknowledgment) {

        logger.info("onMessage Recieved "+ counter);
        System.out.println(++counter + " "+consumerRecord.offset() + "  "+consumerRecord.value());

        acknowledgment.acknowledge();
    }

    @Override
    public void onMessage(Object obj){
        logger.info(" Wrong function invoked");
    }



}
