package com.example.programacion_movil.IService;

import com.example.programacion_movil.Entitys.Libro;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceLibro {
    List<Libro> findAllLibros();
    ResponseEntity<String> saveLibro(Libro libro);
    Libro getByIdLibro(Long id);
    ResponseEntity<String> updateLibro(Libro libro, Long id);
    ResponseEntity<String> deleteLibro(Long id);
}
