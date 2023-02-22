package com.example.KafkaClient.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YamlConfig {



    private String consumertopicname;
    private String consumerserver;
    private String securityprotocol;
    private String sasljaasconfig;
    private String saslmechanism;
    private String keydeserializer;
    private String valuedeserializer;

    private String groupid;

    public String getConsumertopicname() {
        return consumertopicname;
    }

    public void setConsumertopicname(String consumertopicname) {
        this.consumertopicname = consumertopicname;
    }

    public String getConsumerserver() {
        return consumerserver;
    }

    public void setConsumerserver(String consumerserver) {
        this.consumerserver = consumerserver;
    }

    public String getSecurityprotocol() {
        return securityprotocol;
    }

    public void setSecurityprotocol(String securityprotocol) {
        this.securityprotocol = securityprotocol;
    }

    public String getSasljaasconfig() {
        return sasljaasconfig;
    }

    public void setSasljaasconfig(String sasljaasconfig) {
        this.sasljaasconfig = sasljaasconfig;
    }

    public String getSaslmechanism() {
        return saslmechanism;
    }

    public void setSaslmechanism(String saslmechanism) {
        this.saslmechanism = saslmechanism;
    }

    public String getKeydeserializer() {
        return keydeserializer;
    }

    public void setKeydeserializer(String keydeserializer) {
        this.keydeserializer = keydeserializer;
    }

    public String getValuedeserializer() {
        return valuedeserializer;
    }

    public void setValuedeserializer(String valuedeserializer) {
        this.valuedeserializer = valuedeserializer;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
}
