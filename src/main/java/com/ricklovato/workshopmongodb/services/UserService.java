package com.ricklovato.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricklovato.workshopmongodb.domain.User;
import com.ricklovato.workshopmongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
