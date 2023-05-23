package com.daniel.bookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daniel.bookclub.model.Book;
import com.daniel.bookclub.model.LoginUser;
import com.daniel.bookclub.model.User;
import com.daniel.bookclub.service.BookService;
import com.daniel.bookclub.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookSevice;
	
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin",new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register (@Valid@ModelAttribute("newUser")User newUser,BindingResult result,
			Model model,HttpSession session) {
		User thisUser =this.userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin",new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user", thisUser);
		return "redirect:/home";
	}
	
	@PostMapping("/new/login")
	public String newLogin(@Valid@ModelAttribute("newLogin")LoginUser newLogin,BindingResult result,
			Model model, HttpSession session) {
		User thisUser = this.userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser",new User());
			return "index.jsp";
		}
		session.setAttribute("user", thisUser);
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login"; 
		
	}
	
	@GetMapping("/home")
	public String home(HttpSession session,Model model) {
		List<Book>books = bookSevice.findAll();
		if(session.getAttribute("user")== null) {
			return "redirect:/login";
		}
		else {
			model.addAttribute("books",books);
			return "home.jsp";
			
		}
	}
	
	@GetMapping("/new/book")
	public String newBook(Model model,HttpSession session) {
		if(session.getAttribute("user")== null) {
			return "redirect:/login";
		}
		model.addAttribute("newBook",new Book());
		
		return "newBook.jsp";
	}
	
	@PostMapping("/new/book")
	public String createBook (@Valid@ModelAttribute("newBook")Book newBook,BindingResult result,
			Model model, HttpSession session) {
			if(result.hasErrors()) {
				model.addAttribute("newBook",new Book());
				return "newBook.jsp";
			}
			else {
				bookSevice.create(newBook);
				return "redirect:/home";
			}
	}
	
	@GetMapping("/book/{bookid}")
	public String showBook(@PathVariable("bookid")Long bookid,Model model,HttpSession session) {
		Book book = bookSevice.getOne(bookid);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
}
