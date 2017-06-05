package com.jcommerce.cdcpoc.CDCService1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import lombok.Data;

@Data
@Document
public class TestModelObject implements Identifiable<String> {

	@Id
	private String id;
	
	private String prop1;
	
	private String prop2;
}
