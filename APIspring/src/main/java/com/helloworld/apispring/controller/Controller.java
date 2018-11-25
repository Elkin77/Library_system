/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.Ranking_repositorio;
import com.helloworld.apispring.model.entity.Ranking_fifa;
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
    private RankingServicio rankingServicio;

    @RequestMapping(value = "/equipos/", method = RequestMethod.GET)
    public ResponseEntity<List<Ranking_fifa>> obtenerEquipos() {
        List<Ranking_fifa> equipos = rankingServicio.getAll();
        return new ResponseEntity<List<Ranking_fifa>>(equipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/equipos", method = RequestMethod.GET)
    public ResponseEntity<List<Ranking_fifa>> obtenerEquiposByConfe(@RequestParam ("Confe") String confederacion) {
        List<Ranking_fifa> equipos = rankingServicio.getEquipoByConfe(confederacion);
        return new ResponseEntity<List<Ranking_fifa>>(equipos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ranking/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearRanking(@RequestBody Ranking_fifa equipo) {
        long id = rankingServicio.crearRanking(equipo);
        return ResponseEntity.ok().body("Nuevo equipo creado con ID:"+id);
    }
    
    
}
