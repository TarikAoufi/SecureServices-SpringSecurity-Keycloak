package fr.tao.bookservice.configuration;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {
	
	/* Permet de configurer keycloak adapter au même endroit 
	   que spring boot (application.properties), au lieu de keycloak.json 
	 */
 	@Bean
	public KeycloakSpringBootConfigResolver springBootConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}
 	
 	@Bean
 	public KeycloakRestTemplate keycloakRestTemplate(KeycloakClientRequestFactory clientRequestFactory) {
 		return new KeycloakRestTemplate(clientRequestFactory);
 	}

}
