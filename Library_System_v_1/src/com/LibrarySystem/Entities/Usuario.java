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
public class Usuario {

    private int idUsuario;

    private String nombre;

    private String user;

    private String password;

    private String nombreComunidad;

    private String rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String user, String password, String nombreComunidad, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.nombreComunidad = nombreComunidad;
        this.rol = rol;
    }

    public Usuario(String nombre, String user, String password, String nombreComunidad, String rol) {
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.nombreComunidad = nombreComunidad;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /*
    Estos Metodos a continuación realizaran las transacciones apuntando 
    a los procedimientos almacenados programados en el paquete 
    com.LibrarySystem.Database
     */
    public ArrayList<String> listarUsuarios() {

        return null;
    }

    public boolean registrarUsuario() {
        return false;
    }

    public boolean editarUsuario() {
        return false;
    }

    public boolean eliminarUsuario() {
        return false;
    }
}
