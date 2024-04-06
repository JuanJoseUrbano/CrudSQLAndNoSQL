package com.example.programacion_movil.IRepository;

import com.example.programacion_movil.Entitys.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLibro extends JpaRepository<Libro,Long> {
}
