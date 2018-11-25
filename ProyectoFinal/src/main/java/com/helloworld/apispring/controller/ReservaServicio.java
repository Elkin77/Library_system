/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.ReservaRepositorio;
import com.helloworld.apispring.model.dao.UsuarioRepositorio;
import com.helloworld.apispring.model.entity.Reserva;
import com.helloworld.apispring.model.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicio {
    
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public ReservaServicio() {
    }
    
    public List<Reserva> obtenerAllReservas(){
        return reservaRepositorio.obtenerAllReservas();
    }
    
    public long crearReserva(Reserva reserva) {
        return reservaRepositorio.crearReserva(reserva);
    }

}