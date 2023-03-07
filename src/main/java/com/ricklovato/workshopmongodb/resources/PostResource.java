package com.ricklovato.workshopmongodb.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricklovato.workshopmongodb.domain.Post;
import com.ricklovato.workshopmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	private static final Logger logger = LoggerFactory.getLogger(PostResource.class);

	
	@Autowired
	private PostService service;
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
