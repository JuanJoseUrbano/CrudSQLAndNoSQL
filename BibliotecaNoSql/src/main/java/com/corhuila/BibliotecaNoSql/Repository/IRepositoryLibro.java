package com.corhuila.BibliotecaNoSql.Repository;

import com.corhuila.BibliotecaNoSql.Documents.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRepositoryLibro extends MongoRepository<Libro,String> {
}
