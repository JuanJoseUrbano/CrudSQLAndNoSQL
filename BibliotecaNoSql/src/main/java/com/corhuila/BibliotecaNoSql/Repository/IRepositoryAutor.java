package com.corhuila.BibliotecaNoSql.Repository;

import com.corhuila.BibliotecaNoSql.Documents.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRepositoryAutor extends MongoRepository<Autor,String> {
}
