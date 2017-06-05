package com.jcommerce.cdcpoc.CDCService2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestModelObject {

	private String id;
	
	private String prop1;
	
	private String prop2;
	
	public static TestModelObject reverse(TestModelObject toReverse) {
		return TestModelObject.builder()
				.prop1(toReverse.getProp2())
				.prop2(toReverse.getProp1()).build();
	}

}
