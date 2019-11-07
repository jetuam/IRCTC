package com.irctc.operations;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationsApplication.class, args);
	}

	@Bean
	public HttpClient getHttpClient() {
		HttpClient httpClient = HttpClients.createDefault();
		return httpClient;
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory(getHttpClient()));
		return template;
	}

}
