package com.daniel.bookclub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.bookclub.model.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Long>{
	List<Book>findAll();
	
}
