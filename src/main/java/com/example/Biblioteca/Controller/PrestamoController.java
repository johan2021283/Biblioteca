package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Entity.Prestamo;
import com.example.Biblioteca.services.ServicePrestamo;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(name = "/prestamos")
public class PrestamoController {
    @Autowired
    ServicePrestamo servicePrestamo;

    @GetMapping
    public ResponseEntity<List<Prestamo>> obtnerPrestamos() {
        List<Prestamo> prestamos = servicePrestamo.findAll();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtnerlosprestamosporId(@PathVariable Long id) {
        Prestamo prestamo = (Prestamo) servicePrestamo.findById(id);
        if (prestamo != null) {
            return ResponseEntity.ok(prestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void crearPrestamo(@RequestBody Prestamo prestamo) {
        servicePrestamo.crearPrestamo(prestamo);


    }


    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id,@RequestBody Prestamo prestamoActualizado ){
        Prestamo prestamo = servicePrestamo.actualizarPrestamo(id,prestamoActualizado);
        if (prestamo != null){
            return ResponseEntity.ok(prestamo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id){
        servicePrestamo.eliminarPrestamo(id);
        return ResponseEntity.notFound().build();
    }
}
