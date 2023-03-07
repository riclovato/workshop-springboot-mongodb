package com.ricklovato.workshopmongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricklovato.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public Optional<User> findByName(String name);
}
