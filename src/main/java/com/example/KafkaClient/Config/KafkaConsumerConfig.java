package com.example.KafkaClient.Config;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import javax.security.sasl.Sasl;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {


    @Autowired
    YamlConfig yamlConfig;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,yamlConfig.getConsumerserver());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, yamlConfig.getKeydeserializer());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,yamlConfig.getKeydeserializer());
//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,yamlConfig.getSecurityprotocol());
//        props.put(SaslConfigs.SASL_JAAS_CONFIG,yamlConfig.getSasljaasconfig());
//        props.put(SaslConfigs.SASL_MECHANISM,yamlConfig.getSaslmechanism());
        props.put("security.protocol","SASL_SSL");
        props.put("sasl.jaas.config","org.apache.kafka.common.security.plain.PlainLoginModule required username=\"202MPZsJlCVsWX5XqoAs3V\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiIyMDJNUFpzSmxDVnNXWDVYcW9BczNWIiwib3JnYW5pemF0aW9uSWQiOjY5MTYyLCJ1c2VySWQiOjc5ODY3LCJmb3JFeHBpcmF0aW9uQ2hlY2siOiIwZDgzZjI3MC1lMDI4LTQyMTctYjIyYi01ZWIyMWNkYmI2NzQifX0.h-4S4LoiNFsqUrBhh6ubAxtD5zeezhKqATHvllKjfZU\";");
        props.put("sasl.mechanism", "PLAIN");
        props.put("auto.offset.reset", "earliest");

        props.put(ConsumerConfig.GROUP_ID_CONFIG ,yamlConfig.getGroupid());
        props.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,1);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }


}
