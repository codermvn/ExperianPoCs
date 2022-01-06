package com.javatpoint.controller;

import java.util.List;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import com.javatpoint.service.BookServiceException;
import com.javatpoint.service.BooksService;

@RestController
public class BooksController 
{
	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();		
	}
	
@Autowired
RestTemplate restTemplate;
	 
@Autowired
BooksService booksService;

@Autowired
BooksRepository booksRepository;

@Autowired
JmsTemplate jmsTemplate;

@Autowired
Queue queue;

final String message = "unsuccesful transaction";

private static final Logger logger = LoggerFactory.getLogger(BooksController.class);
private final String GLOBAL_ERROR = "Some technical Error";

@GetMapping("/rest")
public String hello() {
	String url = "http://localhost:8081/hello";
	String response = restTemplate.getForObject(url, String.class);
	return response;			
}

@PutMapping("/updatecalling")
public String callMicroservice2() {
    try {
    	String url = "http://localhost:8081/books";    	    	
        String responseFromMS2 = restTemplate.getForObject(url,String.class);
        logger.info("vvv::  responseFromMS2= " + responseFromMS2);
        return responseFromMS2;
    } catch (Exception e) {
        e.printStackTrace();
        return GLOBAL_ERROR;
    }
}

@PostMapping("/newcalling")
private Books updatebooks(@RequestBody Books books) {
  
	booksService.saveOrUpdate(books);
	
  String url = "http://localhost:8081/books";
  books.setAuthor("Abc");
  books = restTemplate.getForObject(url,Books.class);
  return books;
}

@PostMapping("/updateCalling")
public void updateBooks(@RequestBody Books books) throws BookServiceException {
	
    int id = books.getBookid();        
	List<Books> books_new = booksService.getAllBooks();
	
    boolean val=false;
    for (Books books_1 : books_new) {

    	if(books_1.getBookid() == id) {
    		val= true;
    		break;
    	}
    }

    if(val==true) {
    	System.out.println("duplicate entry: exception to be thrown");
    	jmsTemplate.convertAndSend(queue,message);
    	throw new BookServiceException("duplicate entry");    	
     	}
          
    else {
	booksService.saveOrUpdate(books);
	
	String url = "http://localhost:8081/books";    	
	books.setAuthor("Abc");
	HttpEntity<Books> request = new HttpEntity<>(books);
    ResponseEntity<Books> response = restTemplate.exchange(url, HttpMethod.PUT, request,
            Books.class);
    //return response;
	System.out.println("updated succesfully");
}}

//update method, rollback method ,


@PostMapping("/update_Calling")
public void update_Books(@RequestBody Books books) throws BookServiceException {
	
    int id = books.getBookid();        
	List<Books> books_new = booksService.getAllBooks();
	
    boolean val=false;
    for (Books books_1 : books_new) {

    	if(books_1.getBookid() == id) {
    		val= true;
    		break;
    	}
    }

    if(val==true) {
    	System.out.println("duplicate entry: exception to be thrown");
    	jmsTemplate.convertAndSend(queue,id);
    	deleteBookfromdb(id);
    	throw new BookServiceException("duplicate entry");    	
     	}
          
    else {
	booksService.saveOrUpdate(books);
	
	String url = "http://localhost:8081/books";    	
	books.setAuthor("xyz");
	HttpEntity<Books> request = new HttpEntity<>(books);
    ResponseEntity<Books> response = restTemplate.exchange(url, HttpMethod.PUT, request,
            Books.class);
    //return response;
	System.out.println("updated succesfully");
}}

@GetMapping
public ResponseEntity<List<Books>> getBooks() {
	String url = "http://localhost:8081/books";    	
    ResponseEntity<List<Books>> response = restTemplate.exchange(url, HttpMethod.GET,
            HttpEntity.EMPTY, new ParameterizedTypeReference<List<Books>>() {
            });

    return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
}
 
@PutMapping("/update")
public void updateBooksTable(@RequestBody Books books) {
	
	dirtyRead_books(books);
}

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
private int dirtyRead_books(Books books) {
	booksService.saveOrUpdate(books);
	System.out.println(books.getBookid());
	deleteBookfromdb(books.getBookid());
	return 0;
}


@GetMapping("/book")
private List<Books> getAllBooks() 
{
return booksService.getAllBooks();
}

@GetMapping("/book/{bookid}")
private Books getBooks(@PathVariable("bookid") int bookid) 
{
return booksService.getBooksById(bookid);
}

@DeleteMapping("/book/{bookid}")
private void deleteBook(@PathVariable("bookid") int bookid) 
{
booksService.delete(bookid);
}

@PostMapping("/books")
private int saveBook(@RequestBody Books books) 
{
booksService.saveOrUpdate(books);
return books.getBookid();
}

private void deleteBookfromdb(int bookid) 
{
booksService.delete(bookid);
}

}
