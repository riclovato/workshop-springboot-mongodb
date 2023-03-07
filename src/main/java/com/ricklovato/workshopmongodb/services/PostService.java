package com.ricklovato.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricklovato.workshopmongodb.domain.Post;
import com.ricklovato.workshopmongodb.repository.PostRepository;
import com.ricklovato.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// Injeção de dependência da interface UserRepository
	@Autowired
	private PostRepository repo;



	// Busca um usuário por id
	public Post findById(String id) {
		// Busca o usuário no banco de dados pelo id
		Optional<Post> obj = repo.findById(id);
		// Retorna o usuário encontrado ou lança uma exceção ObjectNotFoundException se o usuário não foi encontrado
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}