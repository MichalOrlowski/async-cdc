package com.jcommerce.cdcpoc.CDCService1;

import com.jcommerce.cdcpoc.CDCService1.model.TestModelObject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdcService1Application.class)
public class ContractVerifierBase {

/*   @Autowired
   private TestModelObjectController tmos;*/

   @Before
   public void setUp() throws Exception {
      /* RestAssuredMockMvc.standaloneSetup(tmos);*/
   }
   
	public void assertThatResultSizeIsEqualTo6(List<TestModelObject> result) {
		assert result.size() == 6;
	}

}