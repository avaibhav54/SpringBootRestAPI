package com.api.book.services;

import java.util.ArrayList;
import java.util.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookrepository;

//
//	public static List<Book>list=new ArrayList<>();
//	static
//	{
//		list.add(new Book(1, "Java for begineers","vaibhav agarwal"));
//		list.add(new Book(2, "Python for begineers","Mohan agarwal"));
//		list.add(new Book(3, "C for begineers","ronak agarwal"));
//		list.add(new Book(4, "C++ for begineers","sanjay agarwal"));
//		list.add(new Book(5, "Kotlin for begineers","durgesh agarwal"));
//		
//	}
//	
	public List<Book> getAllBooks()
	{
		return (List<Book>)this.bookrepository.findAll();
	}
	public Book getBookById(int id)
	{
		return this.bookrepository.findById(id);
	}
	//adding book
	public Book addBook(Book book)
	{
		Book res=this.bookrepository.save(book);
		return res;
	}
	public void deleteBook(int id) {
//		for(Book b:list)
//		{
//			if(b.getId()==id)
//			{
//				Book ty=b;
//				 list.remove(b);
//				 return ty;
//			}
//		}
//		return null;
		
		this.bookrepository.deleteById(id);
	}
	public void updateBook(int id, Book book) {
		
//		for(Book b:list)
//		{
//			if(b.getId()==id)
//			{
//				b.setAuthor(book.getAuthor());
//				b.setId(book.getId());
//				b.setTitle(book.getTitle());
//			}
//		}
		
		book.setId(id);
		this.bookrepository.save(book);
	}
}
