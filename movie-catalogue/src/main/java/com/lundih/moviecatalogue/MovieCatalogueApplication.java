package com.lundih.moviecatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogueApplication.class, args);
	}

	// There is already a bean of type Builder in the MovieCatalogueController class
	// Need to add a name qualifier to differentiate them
	@Bean(name = "WebClientBuilder")
	public WebClient.Builder WebClientBuilder() {
		return WebClient.builder();
	}
}
