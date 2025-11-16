package com.quiz;

import com.quiz.config.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class QuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){

		return  new RestTemplate();
	}


	@Bean
	WebClient webClient(){
		return WebClient.builder().baseUrl(AppConstants.questionServiceUrl).build();
	}

}
