package com.api.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String fName;
	private String lname;
	private String language;
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	public Author(int aid, String fName, String lname, String language, Book book) {
		super();
		this.aid = aid;
		this.fName = fName;
		this.lname = lname;
		this.language = language;
		this.book = book;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int aid, String fName, String lname, String language) {
		super();
		this.aid = aid;
		this.fName = fName;
		this.lname = lname;
		this.language = language;
	}
	@Override
	public String toString() {
		return "Author [aid=" + aid + ", fName=" + fName + ", lname=" + lname + ", language=" + language + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
