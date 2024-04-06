package com.example.programacion_movil.Service;

import com.example.programacion_movil.Entitys.Autor;
import com.example.programacion_movil.IRepository.RepositoryAutor;
import com.example.programacion_movil.IService.IServiceAutor;
import com.example.programacion_movil.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceAutor implements IServiceAutor {

    @Autowired
    private RepositoryAutor repositoryAutor;

    @Override
    public List<Autor> findAllAutores() {
        return repositoryAutor.findAll();
    }

    @Override
    public ResponseEntity<String> saveAutor(Autor autor) {
        repositoryAutor.save(autor);
        return Utils.getResponseEntity("Autor guardado con exito!!!", HttpStatus.OK);
    }

    @Override
    public Autor getByIdAutor(Long id) {
        return repositoryAutor.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateAutor(Autor autor, Long id) {
        Optional<Autor> autorById = repositoryAutor.findById(id);
        if (autorById.isPresent()) {
            Autor autorActualizado = new Autor();
            autorActualizado.setId(id);
            autorActualizado.setNombre(autor.getNombre());
            autorActualizado.setApellido(autor.getApellido());
            autorActualizado.setNacionalidad(autor.getNacionalidad());
            autorActualizado.setFechaNacimiento(autor.getFechaNacimiento());
            autorActualizado.setBiografia(autor.getBiografia());
            repositoryAutor.save(autorActualizado);
            return Utils.getResponseEntity("El autor con el Id " + id + " se actualizo con exito.", HttpStatus.OK);
        } else {
            return Utils.getResponseEntity("El autor con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteAutor(Long id) {
        Optional<Autor> autorAEliminar = repositoryAutor.findById(id);
        if (autorAEliminar.isPresent()) {
            repositoryAutor.deleteById(id);
            return Utils.getResponseEntity("El autor con el id: " + id + " se eliminó con exito", HttpStatus.OK);
        }
        return Utils.getResponseEntity("El autor con el id = " + id + " no existe dentro de la base de datos", HttpStatus.NOT_FOUND);
    }
}
