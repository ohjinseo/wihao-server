package com.example.wihao.controller.iot;

import com.example.wihao.dto.iot.MessageRequest;
import com.example.wihao.service.iot.AWSIoTCorePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/iot")
@RestController
public class IotController {
    private final AWSIoTCorePublisher publisher;

    @PostMapping("/publish")
    public void publishMessage(@RequestBody MessageRequest request) {
        publisher.publicMessage(request.getTopic(), request.getMessage());
    }
}
