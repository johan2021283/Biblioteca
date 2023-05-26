package com.example.Biblioteca.services;

import com.example.Biblioteca.Daos.LibroDao;
import com.example.Biblioteca.Entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicioLibroImpl implements ServiceLibro{

    @Autowired
    private LibroDao libroDao;

    @Override
    public List<Libro> findAll() {
        return libroDao.findAll();
    }

    @Override
    public Libro findById(Long id) {
        return libroDao.findById(id).orElseThrow(()  -> new NoSuchElementException("Libro no encontrado"));
    }

    @Override
    public void crearLibro(Libro libro) {
        libroDao.save(libro);

    }

    @Override
    public Libro actualizarLibro(Long id, Libro libroactualizado) {
        Libro libro = findById(id);
        libro.setTitulo(libroactualizado.getTitulo());
        libro.setAutor(libroactualizado.getAutor());
        libro.setEditorial(libroactualizado.getEditorial());
        libro.setAnoPublicacion((libroactualizado.getAnoPublicacion()));
        libro.setNumeroEjemplares((libroactualizado.getNumeroEjemplares()));
        return libroDao.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        Libro libro = findById(id);
        libroDao.delete(libro);

    }
}
