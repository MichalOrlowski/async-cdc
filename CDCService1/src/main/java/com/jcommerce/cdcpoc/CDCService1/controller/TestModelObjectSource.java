package com.jcommerce.cdcpoc.CDCService1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;
import com.jcommerce.cdcpoc.CDCService1.topics.TestTopic;

@RestController
@RequestMapping("/tmos")
@EnableBinding(TestTopic.class)
public class TestModelObjectSource {

    @Autowired
    private TestModelObjectRepository tmos;

    @Autowired
    @Qualifier("test")
    private MessageChannel output;

    @RequestMapping(value = "send",method = GET)
    public void sendTestModelObjects() {
        output.send(MessageBuilder.withPayload(tmos.findAll()).build());
    }
}
