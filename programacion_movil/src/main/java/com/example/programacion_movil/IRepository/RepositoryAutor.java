package com.example.programacion_movil.IRepository;

import com.example.programacion_movil.Entitys.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAutor extends JpaRepository<Autor,Long> {
}
