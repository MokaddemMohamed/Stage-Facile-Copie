package com.projet.annuaire;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
/**
 * 
 * @author LE Dan
 *
 */

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AnnuaireApplication {
	
	public static void main(String[] args){
		SpringApplication.run(AnnuaireApplication.class, args);
	}
}
