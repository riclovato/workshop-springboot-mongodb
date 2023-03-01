package com.ricklovato.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricklovato.workshopmongodb.domain.User;
import com.ricklovato.workshopmongodb.dto.UserDTO;
import com.ricklovato.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	
	@Autowired
	private UserService service;
	
	@GetMapping
 	public ResponseEntity<List<UserDTO>> findAll() {
		logger.info("Método findAll() foi chamado");
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}
