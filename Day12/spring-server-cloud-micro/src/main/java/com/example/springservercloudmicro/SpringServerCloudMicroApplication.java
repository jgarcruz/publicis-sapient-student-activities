package com.example.springservercloudmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringServerCloudMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerCloudMicroApplication.class, args);
	}

}
