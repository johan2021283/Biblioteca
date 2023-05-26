package com.example.Biblioteca.services;

import com.example.Biblioteca.Entity.Libro;

import java.util.List;

public interface ServiceLibro {

    List<Libro> findAll();
    Libro findById(Long id);
    void  crearLibro(Libro libro);
    Libro actualizarLibro(Long id, Libro libro);
    void eliminarLibro(Long id);
}
