package com.gsdev.gsmoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.gsdev.gsmoney.api.config.property.GsmoneyApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(GsmoneyApiProperty.class)
public class GsmoneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsmoneyApiApplication.class, args);
	}

}
