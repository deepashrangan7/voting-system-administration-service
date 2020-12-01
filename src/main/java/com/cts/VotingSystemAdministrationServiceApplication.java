package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com")
@Slf4j
@EnableFeignClients("com.cts")
public class VotingSystemAdministrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemAdministrationServiceApplication.class, args);
		log.info("server started at port 8000 ");
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
