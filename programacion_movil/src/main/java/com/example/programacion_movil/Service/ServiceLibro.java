package com.example.programacion_movil.Service;

import com.example.programacion_movil.Entitys.Autor;
import com.example.programacion_movil.Entitys.Libro;
import com.example.programacion_movil.IRepository.RepositoryLibro;
import com.example.programacion_movil.IService.IServiceLibro;
import com.example.programacion_movil.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLibro implements IServiceLibro {
    @Autowired
    private RepositoryLibro repositoryLibro;


    @Override
    public List<Libro> findAllLibros() {
        return repositoryLibro.findAll();
    }

    @Override
    public ResponseEntity<String> saveLibro(Libro libro) {
        repositoryLibro.save(libro);
        return Utils.getResponseEntity("Libro guardado con exito!!!", HttpStatus.OK);
    }

    @Override
    public Libro getByIdLibro(Long id) {
        return repositoryLibro.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateLibro(Libro libro, Long id) {
        Optional<Libro> libroById = repositoryLibro.findById(id);
        if(libroById.isPresent()){
            Libro libroActualizado = new Libro();
            libroActualizado.setId(id);
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setIsbn(libro.getIsbn());
            libroActualizado.setSinopsis(libro.getSinopsis());
            libroActualizado.setAnioPublicacion(libro.getAnioPublicacion());
            libroActualizado.setGenero(libro.getGenero());
            libroActualizado.setAutor(libro.getAutor());
            repositoryLibro.save(libroActualizado);
            return Utils.getResponseEntity("El libro con el Id " + id + " se actualizo con exito.", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("El libro con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteLibro(Long id) {
        Optional<Libro> libroById = repositoryLibro.findById(id);
        if(libroById.isPresent()){
            repositoryLibro.deleteById(id);
            return Utils.getResponseEntity("El libro con el Id " + id + " se elimino con exito.", HttpStatus.OK);
        }
        return Utils.getResponseEntity("El libro con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
    }
}
