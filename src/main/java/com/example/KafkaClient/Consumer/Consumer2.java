package com.example.KafkaClient.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 implements AcknowledgingMessageListener {

private int counter = 0;
    @Override
    @KafkaListener(topics="custom_topic_1")
    public void onMessage(ConsumerRecord consumerRecord, Acknowledgment acknowledgment) {
        System.out.println(++counter + " "+consumerRecord.offset() + "  "+consumerRecord.value());
        acknowledgment.acknowledge();
    }




    @Override
    public void onMessage(Object o) {
        System.out.println("Second Function \t"+o.getClass());

    }
}
