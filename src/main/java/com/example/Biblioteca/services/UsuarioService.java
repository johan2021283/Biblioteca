package com.example.Biblioteca.services;

import com.example.Biblioteca.Daos.UsuarioDao;
import com.example.Biblioteca.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService implements ServiceUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
         usuarioDao.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        if (usuarioDao.existsById(id)){
            usuario.setId(id);
            return usuarioDao.save(usuario);

        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (usuarioDao.existsById(id)){
            usuarioDao.deleteById(id);
        }

    }
}
