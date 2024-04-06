package com.corhuila.BibliotecaNoSql.Controller;

import com.corhuila.BibliotecaNoSql.Documents.Libro;
import com.corhuila.BibliotecaNoSql.IService.IServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LibroController {
    @Autowired
    IServiceLibro serviceLibro;

    @GetMapping("/getLibros")
    public List<Libro> index() {
        return serviceLibro.findAllLibros();
    }

    @GetMapping("/getLibro/{id}")
    public Libro getById(@PathVariable String id) {
        return serviceLibro.getByIdLibro(id);
    }

    @PostMapping("/saveLibro")
    public ResponseEntity<String> save(@RequestBody(required = true) Libro libro) {
        return serviceLibro.saveLibro(libro);
    }

    @PutMapping("/updateLibro/{id}")
    public ResponseEntity<String> update(@RequestBody Libro libro, @PathVariable String id) {
        return serviceLibro.updateLibro(libro, id);
    }

    @DeleteMapping("/deleteLibro/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return serviceLibro.deleteLibro(id);
    }
}
