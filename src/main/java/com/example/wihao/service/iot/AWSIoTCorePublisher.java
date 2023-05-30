package com.example.wihao.service.iot;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.iot.client.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AWSIoTCorePublisher {
    private final AWSIotMqttClient mqttClient;

    public AWSIoTCorePublisher(
            @Value("${aws.clientId}") String clientId,
            @Value("${aws.endPoint}") String endPoint,
            @Value("${aws.accessKeyId}") String accessKeyId,
            @Value("${aws.secretAccessKey}") String secretAccessKey,
            @Value("${aws.region}") String region
    ) throws AWSIotException {
        this.mqttClient = new AWSIotMqttClient(endPoint, clientId, accessKeyId, secretAccessKey);

        this.mqttClient.connect();
    }

    public void publicMessage(String topic, String message) {
        String jsonMessage = null;
        try {
            jsonMessage = new ObjectMapper().writeValueAsString(Map.of("message", message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        AWSIotMessage iotMessage = new AWSIotMessage(topic, AWSIotQos.QOS1, jsonMessage);
        try {
            mqttClient.publish(iotMessage, 10000);
        } catch (AWSIotException e) {
            throw new RuntimeException(e);
        }
    }
}
