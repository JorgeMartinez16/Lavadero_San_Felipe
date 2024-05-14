package com.jota.sanfelipe;

import com.jota.sanfelipe.entities.Client;
import com.jota.sanfelipe.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SanfelipeApplication {
	private static final Logger log = LoggerFactory.getLogger(SanfelipeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SanfelipeApplication.class, args);
	}

	@Autowired
	ClientRepository clientRepository;

	// Run this if app.db.init.enabled = true
	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {
			System.out.println("Running.....");
			clientRepository.saveAll(List.of());
		};
	}
}
