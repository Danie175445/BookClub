package com.daniel.bookclub.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.daniel.bookclub.model.LoginUser;
import com.daniel.bookclub.model.User;
import com.daniel.bookclub.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		Optional<User>potentialUser = userRepository.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Chose a other Email");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
		if(result.hasErrors()) {
			return null;
		}
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
    	
    	System.out.println("password hashed");
        return this.create(newUser);
	}
	
	public User login(LoginUser newLogin,BindingResult result) {
		Optional<User>potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			 result.rejectValue("email", "Matches", "email not in file");
			 return null;
		}
		User thisUser = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), thisUser.getPassword())) {
			 result.rejectValue("password", "Matches", "Password or email was incorect");
		}
		if(result.hasErrors()) {
			return null;
		}
		return thisUser;
	}
	
	public User getOne(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
	public User create(User newUser) {
		return userRepository.save(newUser);
	}
	
}
