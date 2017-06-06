package com.jcommerce.cdcpoc.CDCService1;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;
import com.jcommerce.cdcpoc.CDCService1.model.TestModelObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdcService1Application.class)
public class ContractVerifierBase {

   @Autowired
   private TestModelObjectRepository tmos;

   @Before
   public void setUp() throws Exception {
       RestAssuredMockMvc.standaloneSetup(tmos);
   }
   
	public void assertThatResultSizeIsEqualTo6(List<TestModelObject> result) {
		assert result.size() == 6;
	}

}