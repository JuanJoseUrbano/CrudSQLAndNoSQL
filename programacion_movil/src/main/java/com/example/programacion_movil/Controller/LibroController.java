package com.example.programacion_movil.Controller;

import com.example.programacion_movil.Entitys.Libro;
import com.example.programacion_movil.IService.IServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private IServiceLibro serviceFactura;

    @GetMapping("/getLibros")
    public List<Libro> index() {
        return serviceFactura.findAllLibros();
    }

    @GetMapping("/getLibro/{id}")
    public Libro getById(@PathVariable Long id) {
        return serviceFactura.getByIdLibro(id);
    }

    @PostMapping("/saveLibro")
    public ResponseEntity<String> save(@RequestBody(required = true) Libro libro) {
        return serviceFactura.saveLibro(libro);
    }

    @PutMapping("/updateLibro/{id}")
    public ResponseEntity<String> update(@RequestBody Libro libro, @PathVariable Long id) {
        return serviceFactura.updateLibro(libro, id);
    }

    @DeleteMapping("/deleteLibro/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return serviceFactura.deleteLibro(id);
    }
}

