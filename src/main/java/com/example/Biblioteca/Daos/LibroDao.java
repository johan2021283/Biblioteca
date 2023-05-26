package com.example.Biblioteca.Daos;

import com.example.Biblioteca.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroDao extends JpaRepository<Libro, Long> {

}
