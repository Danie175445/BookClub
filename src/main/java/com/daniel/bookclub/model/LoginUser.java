package com.daniel.bookclub.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Email is required")
	@Email(message="please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required!")
    @Size(min=1, max=100, message="Password must be between 1 and 5 characters")
    private String password;
	
	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
