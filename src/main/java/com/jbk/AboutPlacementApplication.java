package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AboutPlacementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutPlacementApplication.class, args);
	}
	@Bean
	public RestTemplate getrtObj(){
		return new RestTemplate();
	}

}
