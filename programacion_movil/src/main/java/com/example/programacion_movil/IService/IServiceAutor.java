package com.example.programacion_movil.IService;

import com.example.programacion_movil.Entitys.Autor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceAutor {

    List<Autor> findAllAutores();
    ResponseEntity<String> saveAutor(Autor autor);
    Autor getByIdAutor(Long id);
    ResponseEntity<String> updateAutor(Autor autor, Long id);
    ResponseEntity<String> deleteAutor(Long id);

}
