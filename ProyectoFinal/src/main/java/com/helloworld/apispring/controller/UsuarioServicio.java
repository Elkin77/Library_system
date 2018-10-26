/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.UsuarioRepositorio;
import com.helloworld.apispring.model.entity.Login;
import com.helloworld.apispring.model.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepo;

    public UsuarioServicio() {
    }
    
    public List<Usuario> obtenerAllUsuarios(){
        return usuarioRepo.obtenerAllUsuarios();
    }
    
    public long crearUsuario(Usuario usuario){
        return usuarioRepo.crearUsuario(usuario);
    }
    
    public Login login(String usuario, String password){
        return usuarioRepo.login(usuario, password);
    }

}