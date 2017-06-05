package com.jcommerce.cdcpoc.CDCService2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jcommerce.cdcpoc.CDCService2.model.TestModelObject;

@Service
public class ConsumerService {

	private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

	@Autowired
	private RestTemplate restTemplate;
	
	public List<TestModelObject> reverseProperties() {
		ResponseEntity<Resources<TestModelObject>> tmos = restTemplate.exchange(
				"http://localhost:8080/testModelObjects", 
				HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<Resources<TestModelObject>>() {});
		
		List<TestModelObject> result = tmos.getBody().getContent().stream().map(TestModelObject::reverse).collect(Collectors.toList()); 
		LOG.info(result.toString());		
		return result;
	}
	
}
