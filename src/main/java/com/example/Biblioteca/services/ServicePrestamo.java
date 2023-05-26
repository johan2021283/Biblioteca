package com.example.Biblioteca.services;

import com.example.Biblioteca.Entity.Prestamo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ServicePrestamo {

    List<Prestamo> findAll();
    Object findById(Long id);
    void crearPrestamo(Prestamo prestamo);

    Prestamo actualizarPrestamo(Long id, Prestamo prestamoActualizado);
    void eliminarPrestamo(Long id);
}
