package com.gep.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GepLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(GepLoginApplication.class, args);
	}

}
