package com.ricklovato.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricklovato.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//só esse declaração já faz com que o spring data monte a consulta
	List<Post> findByTitleContainingIgnoreCase(String text);
}
