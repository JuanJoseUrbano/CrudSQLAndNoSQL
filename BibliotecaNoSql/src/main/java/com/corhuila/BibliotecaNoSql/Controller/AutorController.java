package com.corhuila.BibliotecaNoSql.Controller;

import com.corhuila.BibliotecaNoSql.Documents.Autor;
import com.corhuila.BibliotecaNoSql.IService.IServiceAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Autor getById(@PathVariable String id) {
        return serviceAutor.getByIdAutor(id);
    }

    @PostMapping("/saveAutor")
    public ResponseEntity<String> save(@RequestBody(required = true) Autor autor) {
        return serviceAutor.saveAutor(autor);
    }

    @PutMapping("/updateAutor/{id}")
    public ResponseEntity<String> update(@RequestBody Autor autorAntiguo, @PathVariable String id) {
        return serviceAutor.updateAutor(autorAntiguo, id);
    }

    @DeleteMapping("/deleteAutor/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return serviceAutor.deleteAutor(id);
    }

}
