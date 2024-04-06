package com.corhuila.BibliotecaNoSql.Documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Data
@Document(collection = "autores")
public class Autor {
    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String apellido;
    @Field
    private String nacionalidad;
    @Field
    private Date fechaNacimiento;
    @Field
    private String biografia;

    public Autor(){}
}
