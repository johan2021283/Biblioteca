package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Entity.Usuario;
import com.example.Biblioteca.services.ServiceUsuario;
import com.example.Biblioteca.services.UsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    ServiceUsuario serviceUsuario;


    @GetMapping
    private ResponseEntity<List<Usuario>> obtenerUsuario(){
        List<Usuario> usuario = serviceUsuario.findAll();
        return new  ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <Usuario> obtenerusuarioporId(@PathVariable Long id){
        Usuario usuario = serviceUsuario.findById(id);
        if (usuario != null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public void crearUsuario(@RequestBody Usuario usuario){
        serviceUsuario.crearUsuario(usuario);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario actualizarUsuario){
        Usuario usuario = serviceUsuario.actualizarUsuario(id, actualizarUsuario);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        serviceUsuario.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
