package com.moraxweb.psql;

import com.moraxweb.psql.model.Product;
import com.moraxweb.psql.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsqlApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepo productRepo){
		return args -> {
			Product rice = new Product("rice", "Ganador", 35.0);
			productRepo.save(rice);
		};
	}
}
