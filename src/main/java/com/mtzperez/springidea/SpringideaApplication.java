package com.mtzperez.springidea;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class SpringideaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringideaApplication.class, args);
	}


}
