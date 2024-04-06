package com.example.programacion_movil.IRepository;

import com.example.programacion_movil.Entitys.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGenero extends JpaRepository<Genero,Long> {
}
