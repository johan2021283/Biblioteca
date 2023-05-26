package com.example.Biblioteca.Daos;

import com.example.Biblioteca.Entity.Prestamo;
import com.example.Biblioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrestamoDao extends JpaRepository<Prestamo, Usuario> {

    Optional<Object> findById(Long id);

    void deleteById(Long id);
}
