package com.example.programacion_movil.IService;

import com.example.programacion_movil.Entitys.Genero;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceGenero {
    List<Genero> findAllGeneros();
    ResponseEntity<String> saveGenero(Genero genero);
    Genero getByIdGenero(Long id);
    ResponseEntity<String> updateGenero(Genero genero, Long id);
    ResponseEntity<String> deleteGenero(Long id);
}
