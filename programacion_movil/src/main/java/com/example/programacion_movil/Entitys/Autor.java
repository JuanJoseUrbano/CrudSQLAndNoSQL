package com.example.programacion_movil.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 20, nullable = false)
    private String apellido;

    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "fecha_nacimiento", length = 50, nullable = false)
    private Date fechaNacimiento;
    @Column(name = "biografia")
    private String biografia;

    public Autor(){}
}
