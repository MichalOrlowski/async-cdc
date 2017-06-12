package com.jcommerce.cdcpoc.CDCService1.controller;

import com.jcommerce.cdcpoc.CDCService1.topics.TestTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
