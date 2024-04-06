package com.corhuila.BibliotecaNoSql.Documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document(collection = "libros")
public class Libro {
    @Id
    private String id;
    @Field
    private String titulo;
    @Field
    private String isbn;
    @Field
    private Integer anioPublicacion;
    @Field
    private String sinopsis;
    @Field
    private String genero;
    @DBRef
    private Autor autor;
    public Libro(){}
}
