package com.corhuila.BibliotecaNoSql.IService;

import com.corhuila.BibliotecaNoSql.Documents.Libro;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceLibro {
    List<Libro> findAllLibros();
    ResponseEntity<String> saveLibro(Libro libro);
    Libro getByIdLibro(String id);
    ResponseEntity<String> updateLibro(Libro libro, String id);
    ResponseEntity<String> deleteLibro(String id);
}
