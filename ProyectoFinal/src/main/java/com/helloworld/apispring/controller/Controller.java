/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.Login;
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
    
    @Autowired
    private ViajeServicio viajeServicio;

    @RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> obtenerAllUsuarios() {
        List<Usuario> usuarios = usuarioServ.obtenerAllUsuarios();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        long id = usuarioServ.crearUsuario(usuario);
        return ResponseEntity.ok().body("Nuevo usuario creado con ID:" + id);
    }
    
    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ResponseEntity<Login> login(@RequestParam("usuario") String usuario, @RequestParam("password") String password ) {
        Login login = usuarioServ.login(usuario, password);
        return new ResponseEntity<Login>(login, HttpStatus.OK);
    }
    
    @Autowired
    private ViajeServicio viajeServ;

    @RequestMapping(value = "/viajes/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerAllViajes() {
        List<Viaje> viajes = viajeServ.obtenerAllViajes();
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }

    @RequestMapping(value = "/viajes10/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerUltimos10Viajes() {
        List<Viaje> viajes = viajeServ.obtenerUltimos10Viajes();
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }

    @RequestMapping(value = "/viajeEstado/", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarEstadoViajeByIdViaje(@RequestParam("idViaje") int idViaje, @RequestParam("estado") String estado) {
        long id = viajeServ.actualizarEstadoViajeByIdViaje(idViaje, estado);
        return ResponseEntity.ok().body("Estado del viaje con ID:" + id + " actualizado correctamente");
    }

    @RequestMapping(value = "/viajes", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerViajesByFechaOrigenAndDestinoenerAllViajes(@RequestParam("fecha") Date fecha, @RequestParam("origen") String origen, @RequestParam("destino") String destino) {
        List<Viaje> viajes = viajeServ.obtenerViajesByFechaOrigenAndDestino(fecha, origen, destino);
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerViajesitos/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> obtenerViajesOrigenDestinoNro(@RequestParam("origen") String origen, @RequestParam("destino") String destino, @RequestParam("numeroCupos") Integer numeroCupos) {
        List<Viaje> viajes = viajeServ.obtenerViajesOrigenDestinoNro(origen, destino, numeroCupos);
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
    

    @Autowired
    private ReservaServicio reservaServ;

    @RequestMapping(value = "/reservas/", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> obtenerAllReservas() {
        List<Reserva> reservas = reservaServ.obtenerAllReservas();
        return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/reserva/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {
        long id = reservaServ.crearReserva(reserva);
        return ResponseEntity.ok().body("Nueva reserva creada con ID:" + id);
    }

    @RequestMapping(value = "/viaje/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearViaje(@RequestBody Viaje viaje) {
        long id = viajeServicio.publicarViaje(viaje);
        return ResponseEntity.ok().body("Nuevo Viaje publicado con ID:" + id);
    }
    
    @RequestMapping(value = "/DetalleViajes/", method = RequestMethod.GET)
    public ResponseEntity<List<Viaje>> visualizarDetallesViaje(@RequestParam("fecha") Date fecha, @RequestParam("origen") String origen, 
            @RequestParam("destino") String destino, @RequestParam("hora") String hora, @RequestParam("precio") Double precio, 
            @RequestParam("numeroCupos") Integer numeroCupos ) {
        List<Viaje> viajes = viajeServ.obtenerDetallesViaje(fecha, origen, destino, hora, precio, numeroCupos);
        return new ResponseEntity<List<Viaje>>(viajes, HttpStatus.OK);
    }
}
