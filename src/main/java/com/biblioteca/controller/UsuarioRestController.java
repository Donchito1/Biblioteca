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
import com.biblioteca.entities.usuarios;
import com.biblioteca.repository.bibliotecaRepository;
import com.biblioteca.repository.usuariosRepository;

@RestController
@RequestMapping("/user")
public class UsuarioRestController {

	@Autowired
	usuariosRepository UsuarioRepository;
	
	@GetMapping("/users")
	public List<usuarios> findAll() {
		return UsuarioRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> get(@PathVariable long id){
		Optional<usuarios> usuario = UsuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(usuario.get(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users/crear")
	public ResponseEntity<?> post(@RequestBody usuarios input){
		usuarios guardar = UsuarioRepository.save(input);
		return ResponseEntity.ok(guardar);
	}
	
	@PutMapping("/users/actualizar/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody usuarios input){
		Optional<usuarios> optionalUsu= UsuarioRepository.findById(id);
		if(optionalUsu.isPresent()) {
			usuarios newBook = optionalUsu.get();
			newBook.setUsername(input.getUsername());
			newBook.setPassword(input.getPassword());
			newBook.setEmail(input.getEmail());
			usuarios guardar = UsuarioRepository.save(newBook);
			return new ResponseEntity<>(guardar,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		UsuarioRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
