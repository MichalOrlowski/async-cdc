package com.jcommerce.cdcpoc.CDCService2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.client.RestTemplate;

import com.jcommerce.cdcpoc.CDCService2.model.TestModelObject;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CdcService2Application {


	public static void main(String[] args) {
		SpringApplication.run(CdcService2Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@ServiceActivator(inputChannel=Sink.INPUT)
	public void processTMO(TestModelObject toProcess) {
		System.out.println(toProcess);
	}

//	@Bean
//	public CommandLineRunner run(ConsumerService service) throws Exception {
//		return args -> {
//			service.reverseProperties();
//		};
//	}
}
