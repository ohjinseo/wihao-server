package com.example.wihao.service.iot;


import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AWSIoTCorePublisherTest {

    @Value("${aws.clientId}")
    private String clientId;

    @Value("${aws.endPoint}")
    private String endPoint;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;

    @Value("${aws.region}")
    private String region;

    @Mock
    private AWSIotMqttClient awsIotMqttClient;

    @InjectMocks
    private AWSIoTCorePublisher awsIoTCorePublisher;

    @BeforeEach
    void setUp() throws AWSIotException {
        MockitoAnnotations.openMocks(this);
        awsIoTCorePublisher = new AWSIoTCorePublisher(clientId, endPoint, accessKeyId, secretAccessKey, region);
    }

    @Test
    void testPublishMessage() throws AWSIotException {
        String topic = "test";
        String message = "Hello";
        awsIoTCorePublisher.publicMessage(topic, message);

        verify(awsIotMqttClient, times(1)).publish(any(AWSIotMessage.class), eq(10000));
    }
}