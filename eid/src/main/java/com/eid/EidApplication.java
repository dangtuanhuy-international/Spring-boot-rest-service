package com.eid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration(
// exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class EidApplication {

	public static void main(String[] args) {
		SpringApplication.run(EidApplication.class, args);
	}

}
