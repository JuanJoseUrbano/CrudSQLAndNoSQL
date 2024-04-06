package com.example.programacion_movil.Service;

import com.example.programacion_movil.Entitys.Genero;
import com.example.programacion_movil.IRepository.RepositoryGenero;
import com.example.programacion_movil.IService.IServiceGenero;
import com.example.programacion_movil.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceGenero implements IServiceGenero {

    @Autowired
    private RepositoryGenero repositoryGenero;

    @Override
    public List<Genero> findAllGeneros() {
        return repositoryGenero.findAll();
    }

    @Override
    public ResponseEntity<String> saveGenero(Genero genero) {
        repositoryGenero.save(genero);
        return Utils.getResponseEntity("Genero guardado con exito!!!", HttpStatus.OK);
    }

    @Override
    public Genero getByIdGenero(Long id) {
        return repositoryGenero.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateGenero(Genero genero, Long id) {
        Optional<Genero> generoById = repositoryGenero.findById(id);
        if (generoById.isPresent()) {
            Genero generoAtualizado = new Genero();
            generoAtualizado.setId(id);
            generoAtualizado.setNombre(genero.getNombre());
            generoAtualizado.setDescripcion(genero.getDescripcion());
            repositoryGenero.save(generoAtualizado);
            return Utils.getResponseEntity("El genero con el Id " + id + " se actualizo con exito.", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("El genero con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteGenero(Long id) {
        Optional<Genero> generoById = repositoryGenero.findById(id);
        if(generoById.isPresent()){
            repositoryGenero.deleteById(id);
            return Utils.getResponseEntity("El genero con el Id " + id + " se elimino con exito.", HttpStatus.OK);
        }
        return Utils.getResponseEntity("El genero con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
    }
}
