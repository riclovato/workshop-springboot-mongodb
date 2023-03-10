package com.ricklovato.workshopmongodb.resources;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricklovato.workshopmongodb.domain.Post;
import com.ricklovato.workshopmongodb.resources.util.URL;
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
	
	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue ="") String text) {
		text = URL.decodeParam(text);
		List<Post>list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findSearch(
			@RequestParam(value="text", defaultValue ="") String text,
			@RequestParam(value="minDate", defaultValue ="") String minDate,
			@RequestParam(value="maxDate", defaultValue ="") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.converDate(minDate, new Date(0));
		Date max = URL.converDate(maxDate, new Date());
		List<Post>list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
}
