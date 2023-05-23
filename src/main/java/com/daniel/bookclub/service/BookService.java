package com.daniel.bookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.bookclub.model.Book;
import com.daniel.bookclub.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book getOne(Long id) {
		return this.bookRepository.findById(id).orElse(null);
	}
	
	public Book create(Book newBook) {
		return bookRepository.save(newBook);
	}
	
}
