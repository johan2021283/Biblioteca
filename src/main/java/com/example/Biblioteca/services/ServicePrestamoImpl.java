package com.example.Biblioteca.services;

import com.example.Biblioteca.Daos.LibroDao;
import com.example.Biblioteca.Daos.PrestamoDao;
import com.example.Biblioteca.Daos.UsuarioDao;
import com.example.Biblioteca.Entity.Libro;
import com.example.Biblioteca.Entity.Prestamo;
import com.example.Biblioteca.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicePrestamoImpl implements ServicePrestamo {
    @Autowired
    private PrestamoDao prestamoDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private LibroDao libroDao;

    @Override
    public List<Prestamo> findAll() {
        return prestamoDao.findAll();
    }

    @Override
    public Prestamo findById(Long id) {
        return (Prestamo) prestamoDao.findById(id).orElseThrow(() -> new NoSuchElementException("Prestamo no encontrado"));
    }

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        prestamoDao.save(prestamo);

    }

    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamoActualizado) {
        Prestamo prestamoExistente = (Prestamo) prestamoDao.findById(id).orElse(null);
        if (prestamoExistente !=null){
            prestamoExistente.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
            prestamoExistente.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
            return prestamoDao.save(prestamoExistente);
        }
        return null;
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoDao.deleteById(id);

    }

}