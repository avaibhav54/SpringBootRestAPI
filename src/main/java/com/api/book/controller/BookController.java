package com.api.book.controller;

import java.util.List;import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;


@RestController
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<Book> getBooks()
	{
		Book b= this.bookservice.getBookById(1);
		if(b==null)return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	return ResponseEntity.of(Optional.of(b));	
	
	}
	@GetMapping("/all")
	public List<Book> getAllBooks()
	{
		return this.bookservice.getAllBooks();
		}
	
	//ADD NEW BOOK HANDLER
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b=this.bookservice.addBook(book);
		return b;
	}
	
	//deletenew book
	@DeleteMapping("/books/{bookId}")
	public boolean deleteBook(@PathVariable("bookId")int id )
	{
		this.bookservice.deleteBook(id);
		return true;
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int id)
	{
		this.bookservice.updateBook(id,book);
		return book;
	}
	
}
