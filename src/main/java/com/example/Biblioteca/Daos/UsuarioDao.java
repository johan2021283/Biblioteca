package com.example.Biblioteca.Daos;

import com.example.Biblioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
}
