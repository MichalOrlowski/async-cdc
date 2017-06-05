package com.jcommerce.cdc.poc.CDCService2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jcommerce.cdcpoc.CDCService2.CdcService2Application;
import com.jcommerce.cdcpoc.CDCService2.model.TestModelObject;
import com.jcommerce.cdcpoc.CDCService2.service.ConsumerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CdcService2Application.class })
public class ConsumerServiceTest {

	
	@Autowired
	private ConsumerService service;
	
	@Test
	public void shouldReversePropertiesInAllObjectsInList() {
		//given
		//when
		List<TestModelObject> result = service.reverseProperties();
		
		//then
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(6);
//		for (TestModelObject tmo: result) {
//			
//		}
	}
}
