package com.yyn.phone.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication { //serverTimezone=UTC&    (exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}
