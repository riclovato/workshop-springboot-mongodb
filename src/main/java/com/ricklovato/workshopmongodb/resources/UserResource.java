package com.ricklovato.workshopmongodb.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricklovato.workshopmongodb.domain.User;
import com.ricklovato.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	
	@Autowired
	private UserService service;
	
	@GetMapping
 	public ResponseEntity<List<User>> findAll() {
		logger.info("Método findAll() foi chamado");
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
