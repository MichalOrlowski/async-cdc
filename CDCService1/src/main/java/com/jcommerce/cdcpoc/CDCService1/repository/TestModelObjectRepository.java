package com.jcommerce.cdcpoc.CDCService1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;

import com.jcommerce.cdcpoc.CDCService1.model.TestModelObject;

@RepositoryRestResource
@ExposesResourceFor(TestModelObject.class)
//@RequestMapping("/testModelObjects")
public interface TestModelObjectRepository extends MongoRepository<TestModelObject, String> {

}
