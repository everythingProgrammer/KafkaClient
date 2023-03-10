package com.example.KafkaClient.Consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//@Component
public class ConductorConsumer implements AcknowledgingConsumerAwareMessageListener<String,String> {

    private static int counter = 0;

    @Override
    @KafkaListener(topics="custom_topic_1")
    public void onMessage(ConsumerRecord consumerRecord, Acknowledgment acknowledgment, Consumer consumer) {
        System.out.println(consumerRecord.key().toString()+" - "+consumerRecord.value().toString());
        System.out.println(++counter);
//        acknowledgment.acknowledge();
    }

}
