package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Entity.Libro;
import com.example.Biblioteca.services.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    ServiceLibro serviceLibro;

    @GetMapping
    private ResponseEntity<List<Libro>> obtenerlibros(){
        List<Libro> libro = serviceLibro.findAll();
        return new  ResponseEntity<>(libro, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Libro> obtenerLibropoId(@PathVariable Long id){
        Libro libro = serviceLibro.findById(id);
        return ResponseEntity.ok(libro);

    }
    @PostMapping
    public void crearlibro(@RequestBody Libro libro) {
        serviceLibro.crearLibro(libro);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroactualizado ){
        Libro libro = serviceLibro.actualizarLibro(id, libroactualizado);
        return ResponseEntity.ok(libro);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        serviceLibro.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

}
