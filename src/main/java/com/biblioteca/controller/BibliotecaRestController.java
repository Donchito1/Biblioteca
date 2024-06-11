package com.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entities.Book;
import com.biblioteca.repository.bibliotecaRepository;

@RestController
@RequestMapping("/book")
public class BibliotecaRestController {

	@Autowired
	bibliotecaRepository BibliotecaRepository;
	
	@GetMapping("/books")
	public List<Book> findAll() {
		return BibliotecaRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> get(@PathVariable long id){
		Optional<Book> Book = BibliotecaRepository.findById(id);
		if(Book.isPresent()) {
			return new ResponseEntity<>(Book.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Book.get(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/books/crear")
	public ResponseEntity<?> post(@RequestBody Book input){
		Book guardar = BibliotecaRepository.save(input);
		return ResponseEntity.ok(guardar);
	}
	
	@PutMapping("/books/actualizar/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody Book input){
		Optional<Book> optionalBook = BibliotecaRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book newBook = optionalBook.get();
			newBook.setAuthor(input.getAuthor());
			newBook.setIsbn(input.getIsbn());
			newBook.setTitle(input.getTitle());
			Book guardar = BibliotecaRepository.save(newBook);
			return new ResponseEntity<>(guardar,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/books/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		BibliotecaRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
