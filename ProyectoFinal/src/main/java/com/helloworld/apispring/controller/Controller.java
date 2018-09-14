/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;



import com.helloworld.apispring.model.entity.Reserva;
import com.helloworld.apispring.model.entity.Usuario;
import com.helloworld.apispring.model.entity.Viaje;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(value = "/usuario/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        long id = usuarioServ.crearUsuario(usuario);
        return ResponseEntity.ok().body("Nuevo usuario creado con ID:"+id);
    }
    
    @Autowired
    private ViajeServicio viajeServ;
    
    @RequestMapping(value = "/viajes/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerAllViajes() {
        List<Viaje> viajes = viajeServ.obtenerAllViajes();
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/viajes10/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerUltimos10Viajes(){
        List<Viaje> viajes = viajeServ.obtenerUltimos10Viajes();
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/viaje/", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarEstadoViajeByIdViaje(@RequestParam("idViaje") int idViaje, @RequestParam("estado") String estado) {
        long id = viajeServ.actualizarEstadoViajeByIdViaje(idViaje, estado);
        return ResponseEntity.ok().body("Estado del viaje con ID:"+id +" actualizado correctamente");
    }
    
    @RequestMapping(value = "/viajes", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerViajesByFechaOrigenAndDestinoenerAllViajes(@RequestParam("fecha") Date fecha, @RequestParam("origen") String origen, @RequestParam("destino") String destino) {
        List<Viaje> viajes = viajeServ.obtenerViajesByFechaOrigenAndDestino(fecha, origen, destino);
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
    
    @Autowired
    private ReservaServicio reservaServ;
    
    @RequestMapping(value = "/reservas/", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> obtenerAllReservas() {
        List<Reserva> reservas = reservaServ.obtenerAllReservas();
        return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
    }
}
