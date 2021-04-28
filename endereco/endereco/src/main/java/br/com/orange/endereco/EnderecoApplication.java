package br.com.orange.endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnderecoApplication.class, args);
	}

}
