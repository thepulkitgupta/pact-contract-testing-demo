package com.example.ConsumerProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerProducerApplication {
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return new RestTemplate();
//	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerProducerApplication.class, args);
//		Client obj=new Client();
//		obj.fun("http://localhost:8080/getJson");
	}

}
