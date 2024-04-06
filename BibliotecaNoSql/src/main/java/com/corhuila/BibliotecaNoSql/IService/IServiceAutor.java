package com.corhuila.BibliotecaNoSql.IService;

import com.corhuila.BibliotecaNoSql.Documents.Autor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceAutor {
    List<Autor> findAllAutores();
    ResponseEntity<String> saveAutor(Autor autor);
        Autor getByIdAutor(String id);
    ResponseEntity<String> updateAutor(Autor autor, String id);
    ResponseEntity<String> deleteAutor(String id);
}
