/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.UsuarioRepositorio;
import com.helloworld.apispring.model.dao.ViajeRepositorio;
import com.helloworld.apispring.model.entity.Usuario;
import com.helloworld.apispring.model.entity.Viaje;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViajeServicio {
    
    @Autowired
    private ViajeRepositorio viajeRepositorio;

    public ViajeServicio() {
    }
    
    public List<Viaje> obtenerAllViajes(){
        return viajeRepositorio.obtenerAllViajes();
    }
    
    public List<Viaje> obtenerUltimos10Viajes(){
        return viajeRepositorio.obtenerUltimos10Viajes();
    }
    
    public List<Viaje> obtenerViajesByFechaOrigenAndDestino(Date fecha, String origen, String destino){
        return viajeRepositorio.obtenerViajesByFechaOrigenAndDestino(fecha, origen, destino);
    }
    
    public List<Viaje> obtenerViajesOrigenDestinoNro(String origen, String destino, Integer numeroCupos){
        return viajeRepositorio.obtenerViajesDestinoOrigenNro(origen, destino, numeroCupos);
    }
    
    public long actualizarEstadoViajeByIdViaje(int idViaje, String estado) {
        return viajeRepositorio.actualizarEstadoViajeByIdViaje(idViaje, estado);
    }
    
    public long publicarViaje (Viaje viaje){
        return viajeRepositorio.crearViaje(viaje);
    }
    
    public List<Viaje> obtenerDetallesViaje(Date fecha, String origen, String destino, String hora, Double precio, Integer numeroCupos  ){
        return viajeRepositorio.obtenerDetallesViaje(fecha, origen, destino, hora, precio, numeroCupos);
    }

}