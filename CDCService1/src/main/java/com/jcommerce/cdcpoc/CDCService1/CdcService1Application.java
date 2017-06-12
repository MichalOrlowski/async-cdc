package com.jcommerce.cdcpoc.CDCService1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcommerce.cdcpoc.CDCService1.model.TestModelObject;
import com.jcommerce.cdcpoc.CDCService1.repository.TestModelObjectRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PreDestroy;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jcommerce.cdcpoc"})
public class CdcService1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(CdcService1Application.class, args);
	}
	
	@PostMapping
	@Autowired
	public void saveInitialData(TestModelObjectRepository tmos) throws FileNotFoundException, IOException {
		String jsonInitialData  = new String();
		File jsonFile = new File(getClass().getClassLoader().getResource("data/initial_data.json").getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
			jsonInitialData =  br.lines().collect(Collectors.joining());
		}
		ObjectMapper jsonMapper = new ObjectMapper();
		List<TestModelObject> objectsList = jsonMapper.readValue(jsonInitialData, new TypeReference<List<TestModelObject>>() {});
		tmos.save(objectsList);
	}
	
	@Bean(destroyMethod = "stop") 
	public MongodProcess embeddedMongoInstance() throws IOException {
		MongodStarter starter = MongodStarter.getDefaultInstance();

		String bindIp = "localhost";
		int port = 27017;
		IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
				.net(new Net(bindIp, port, Network.localhostIsIPv6())).build();

		MongodExecutable mongodExecutable = starter.prepare(mongodConfig);
		return mongodExecutable.start();
	}
	
	@PreDestroy
	public void destroy() {
		
	}
}
