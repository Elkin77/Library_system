/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import java.util.ArrayList;

/**
 *
 * @author brayan
 */
public class Tema {

    private int idTema;

    private String nombre;

    private String descripcion;

    private String codigoRegistro;

    private int idCategoria;

    public Tema() {
    }

    public Tema(String nombre, String descripcion, String codigoRegistro, int idCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoRegistro = codigoRegistro;
        this.idCategoria = idCategoria;
    }

    public Tema(int idTema, String nombre, String descripcion, String codigoRegistro, int idCategoria) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoRegistro = codigoRegistro;
        this.idCategoria = idCategoria;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /*
    Estos Metodos a continuación realizaran las transacciones apuntando 
    a los procedimientos almacenados programados en el paquete 
    com.LibrarySystem.Database
     */
    public ArrayList<String> listarTemas() {

        return null;
    }

    public boolean registrarTemas() {
        return false;
    }

    public boolean editarTemas() {
        return false;
    }

    public boolean eliminarTemas() {
        return false;
    }

}
