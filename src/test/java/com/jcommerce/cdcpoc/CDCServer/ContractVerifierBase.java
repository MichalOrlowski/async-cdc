package com.jcommerce.cdcpoc.CDCServer;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jcommerce.cdcpoc.CDCService1.CdcService1Application;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdcService1Application.class)
public class ContractVerifierBase {

   @Autowired
   private WebApplicationContext context;

   @Before
   public void setUp() throws Exception {
       RestAssuredMockMvc.webAppContextSetup(context);
   }
}