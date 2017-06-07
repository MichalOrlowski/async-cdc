package com.jcommerce.cdcpoc.CDCService1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;

@RepositoryRestController
@RequestMapping("/testModelObjects")
public class TestModelObjectController {

	@Autowired
	private TestModelObjectRepository tmos;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> getTestModelObjects() {
		return ResponseEntity.ok(tmos.findAll());
	}
}
