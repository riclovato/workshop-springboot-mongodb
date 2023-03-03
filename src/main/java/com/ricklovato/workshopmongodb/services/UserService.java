package com.ricklovato.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricklovato.workshopmongodb.domain.User;
import com.ricklovato.workshopmongodb.dto.UserDTO;
import com.ricklovato.workshopmongodb.repository.UserRepository;
import com.ricklovato.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// Injeção de dependência da interface UserRepository
	@Autowired
	private UserRepository repo;

	// Retorna todos os usuários cadastrados
	public List<User> findAll(){
		return repo.findAll();
	}

	// Busca um usuário por id
	public User findById(String id) {
		// Busca o usuário no banco de dados pelo id
		Optional<User> obj = repo.findById(id);
		// Retorna o usuário encontrado ou lança uma exceção ObjectNotFoundException se o usuário não foi encontrado
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	/*
	 * o Optional<User> é usado para representar o resultado da busca de um usuário pelo seu id 
	 * na base de dados. Se o usuário é encontrado, o Optional irá conter o objeto User correspondente; caso contrário, o Optional será vazio. 
	 * O método orElseThrow é chamado para obter o valor contido no Optional, ou lançar uma exceção do tipo ObjectNotFoundException se o Optional estiver vazio, 
	 * indicando que o objeto não foi encontrado na base de dados.
	 */
}
