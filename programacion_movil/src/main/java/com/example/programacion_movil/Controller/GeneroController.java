package com.example.programacion_movil.Controller;

import com.example.programacion_movil.Entitys.Genero;
import com.example.programacion_movil.IService.IServiceGenero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GeneroController {

    @Autowired
    private IServiceGenero serviceGenero;

    @GetMapping("/getGeneros")
    public List<Genero> getAll() {
        return serviceGenero.findAllGeneros();
    }
    @GetMapping("/getGenero/{id}")
    public Genero getById(@PathVariable Long id){
        return serviceGenero.getByIdGenero(id);
    }

    @PostMapping("/saveGenero")
    public ResponseEntity<String> save(@RequestBody(required = true) Genero genero) {
        return serviceGenero.saveGenero(genero);
    }

    @PutMapping("/updateGenero/{id}")
    public ResponseEntity<String> update(@RequestBody Genero genero, @PathVariable Long id) {
        return serviceGenero.updateGenero(genero, id);
    }
    @DeleteMapping("/deleteGenero/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return serviceGenero.deleteGenero(id);
    }
}
