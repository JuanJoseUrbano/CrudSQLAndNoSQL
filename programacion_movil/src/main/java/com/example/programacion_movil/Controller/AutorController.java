package com.example.programacion_movil.Controller;

import com.example.programacion_movil.Entitys.Autor;
import com.example.programacion_movil.IService.IServiceAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AutorController {
    @Autowired
    private IServiceAutor serviceAutor;

    @GetMapping("/getAutores")
    public List<Autor> index() {
        return serviceAutor.findAllAutores();
    }

    @GetMapping("/getAutor/{id}")
    public Autor getById(@PathVariable Long id) {
        return serviceAutor.getByIdAutor(id);
    }

    @PostMapping("/saveAutor")
    public ResponseEntity<String> save(@RequestBody(required = true) Autor autor) {
        return serviceAutor.saveAutor(autor);
    }

    @PutMapping("/updateAutor/{id}")
    public ResponseEntity<String> update(@RequestBody Autor autorAntiguo, @PathVariable Long id) {
        return serviceAutor.updateAutor(autorAntiguo, id);
    }

    @DeleteMapping("/deleteAutor/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return serviceAutor.deleteAutor(id);
    }
}

