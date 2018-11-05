/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Libro {

    private int id_libro;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String autor;
    private String foto;
    private int id_biblioteca;

    public Libro(int id_libro, String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
    }

    public Libro(String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    /*
    Estos Metodos a continuación realizaran las transacciones apuntando 
    a los procedimientos almacenados programados en el paquete 
    com.LibrarySystem.Database
     */
    public ArrayList<String> listarLibros() {

        return null;
    }

    public boolean registrarLibro() {
        return false;
    }

    public boolean editarLibro() {
        return false;
    }

    public boolean eliminarLibro() {
        return false;
    }

}
