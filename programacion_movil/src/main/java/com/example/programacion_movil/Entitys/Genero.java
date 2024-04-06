package com.example.programacion_movil.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name="generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Genero(){}

}
