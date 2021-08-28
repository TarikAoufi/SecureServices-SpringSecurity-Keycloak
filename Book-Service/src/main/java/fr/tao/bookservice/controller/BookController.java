package fr.tao.bookservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.tao.bookservice.repositories.BookRepository;
import fr.tao.bookservice.utilities.Util;

@Controller
public class BookController {
	
	private KeycloakRestTemplate keycloakRestTemplate;
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository, KeycloakRestTemplate keycloakRestTemplate) {
		this.bookRepository = bookRepository;
		this.keycloakRestTemplate = keycloakRestTemplate;
	}
	
	@GetMapping("/")
    public String index(){
        return Util.ATTRIBUTE_INDEX;
    }
	
	@GetMapping(Util.ENDPOINT_BOOKS)
    public String books(Model model){
        model.addAttribute(Util.ATTRIBUTE_BOOKS, bookRepository.findAll());
        return Util.ATTRIBUTE_BOOKS;
    }
	
	@GetMapping(Util.ENDPOINT_BOOKMANAGERS)
    public String bookmanagers(Model model){
        PagedModel<?> pageBookmanagers = keycloakRestTemplate.getForObject(Util.URL_BOOKMANAGER_SERVICE, PagedModel.class);
		model.addAttribute(Util.ATTRIBUTE_BOOKMANAGERS, pageBookmanagers);
        return Util.ATTRIBUTE_BOOKMANAGERS;
    }
	
	@GetMapping(Util.ENDPOINT_JWT)
	@ResponseBody
	public Map<String, String> map(HttpServletRequest request) {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
		KeycloakPrincipal<?> principal = (KeycloakPrincipal<?>) token.getPrincipal();
		KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
		Map<String, String> map = new HashMap<>();
		map.put(Util.ACCESS_TOKEN_NAME, keycloakSecurityContext.getTokenString());
		return map;
	}
	
	/**
	 * Permet de gérer les exceptions
	 */
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute(Util.ATTRIBUTE_ERRORMESSAGE, Util.MESSAGE_PERMISSION_ISSUE);	
		return Util.ATTRIBUTE_ERRORS;
	}

}
