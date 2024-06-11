package com.biblioteca.repository;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bibliotecaRepository extends JpaRepository<Book, Long> {

}
