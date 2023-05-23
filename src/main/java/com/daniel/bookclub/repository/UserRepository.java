package com.daniel.bookclub.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.bookclub.model.User;
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	Optional<User> findByEmail(String email);
}
