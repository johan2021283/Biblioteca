package com.example.Biblioteca.services;

import com.example.Biblioteca.Daos.LibroDao;
import com.example.Biblioteca.Daos.PrestamoDao;
import com.example.Biblioteca.Entity.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService {
    private final PrestamoDao prestamoDao;
    private final LibroDao libroDao;

    @Autowired
    public DevolucionService(PrestamoDao prestamoDao, LibroDao libroDao){
        this.prestamoDao = prestamoDao;
        this.libroDao = libroDao;
    }

    public void realizarDevolucion(Prestamo prestamo){


    }

}
