package com.example.programacion_movil.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //Esta anotacion por defecto me construye getters y setters
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false, length = 60)
    private String titulo;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "anio_publicacion", nullable = false)
    private Integer anioPublicacion;
    @Column(name = "sinopsis")
    private String sinopsis;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public Libro(){}

}
