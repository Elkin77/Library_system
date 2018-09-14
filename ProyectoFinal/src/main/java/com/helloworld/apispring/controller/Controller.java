/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;



import com.helloworld.apispring.model.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
   
   @Autowired
    private UsuarioServicio usuarioServ;
    
    @RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> obtenerAllUsuarios() {
        List<Usuario> usuarios = usuarioServ.obtenerAllUsuarios();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    
}
