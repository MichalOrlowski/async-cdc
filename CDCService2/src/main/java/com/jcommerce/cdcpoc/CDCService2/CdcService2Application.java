package com.jcommerce.cdcpoc.CDCService2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CdcService2Application {


	public static void main(String[] args) {
		SpringApplication.run(CdcService2Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	

//	@Bean
//	public CommandLineRunner run(ConsumerService service) throws Exception {
//		return args -> {
//			service.reverseProperties();
//		};
//	}
}
