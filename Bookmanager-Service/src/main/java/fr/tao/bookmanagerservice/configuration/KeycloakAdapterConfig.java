package fr.tao.bookmanagerservice.configuration;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {
	
	/**
	 * Permet de configurer keycloak adapter au même endroit 
	 * que spring boot (application.properties), aulieu de keycloak.json
	 */
 	@Bean
	public KeycloakSpringBootConfigResolver springBootConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

}
