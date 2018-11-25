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
import org.springframework.stereotype.Service;

/**
 *
 * @author BOG-A209-E-015
 */
@Service

public class RankingServicio {

    @Autowired
    private Ranking_repositorio rankingRepositorio;

    public RankingServicio() {
    }

    public List<Ranking_fifa> getAll() {
        return rankingRepositorio.getEquipo();
    }
    
    public List<Ranking_fifa> getEquipoByConfe(String confe) {
        return rankingRepositorio.getEquipoByConfe(confe);
    }
    
    public long crearRanking (Ranking_fifa ranking){
        return rankingRepositorio.crearRanking(ranking);
    }

}
