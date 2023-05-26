package com.example.Biblioteca.services;

import com.example.Biblioteca.Entity.Usuario;

import java.util.List;

public interface ServiceUsuario {
    List<Usuario> findAll();
    Usuario findById(Long id);
    void crearUsuario (Usuario usuario);
    Usuario actualizarUsuario (Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}
