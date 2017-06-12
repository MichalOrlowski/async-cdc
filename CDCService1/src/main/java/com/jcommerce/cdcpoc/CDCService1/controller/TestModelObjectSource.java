package com.jcommerce.cdcpoc.CDCService1.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;

@Configuration
@EnableBinding(Source.class)
public class TestModelObjectSource {

    @Autowired
    private TestModelObjectRepository tmos;
/*
    @RequestMapping(method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> getTestModelObjects() {
		return ResponseEntity.ok(tmos.findAll());
	}*/

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage(tmos.findAll());
    }
}
