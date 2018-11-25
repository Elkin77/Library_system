/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BOG-A209-E-015
 */
@Entity
@Table(name = "ranking_fifa")
public class Ranking_fifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private int rankID;
    
    @Column(name = "rank")
    private int rank;
    
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_abrv")
    private String countryAbrv;
    @Column(name = "points")
    private double Points;
    @Column(name = "confederation")
    private String Confederation;
    @Column(name = "fecha")
    private int Fecha;

    

    public Ranking_fifa() {
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAbrv() {
        return countryAbrv;
    }

    public void setCountryAbrv(String countryAbrv) {
        this.countryAbrv = countryAbrv;
    }

    public double getPoints() {
        return Points;
    }

    public void setPoints(double Points) {
        this.Points = Points;
    }

    public String getConfederation() {
        return Confederation;
    }

    public void setConfederation(String Confederation) {
        this.Confederation = Confederation;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }

}
