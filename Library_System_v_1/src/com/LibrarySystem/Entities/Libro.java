/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import com.LibrarySystem.Database.LibroDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int id_categoria;

    public Libro(int id_libro, String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
    }

    public Libro(int id_libro, String nombre, String descripcion, String ubicacion, String autor, String foto) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
    }

    public Libro(String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
    }

    public Libro(String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca, int id_categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
        this.id_categoria = id_categoria;
    }

    public Libro() {
    }

    public Libro(int id_libro, String nombre, String descripcion, String ubicacion, String autor, String foto, int id_biblioteca, int id_categoria) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
        this.foto = foto;
        this.id_biblioteca = id_biblioteca;
        this.id_categoria = id_categoria;
    }

    public Libro(int id_libro, String nombre, String descripcion, String ubicacion, String autor) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.autor = autor;
    }
    
    

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public boolean registrarLibro(Libro libro) {

        LibroDB new_libro = new LibroDB();
        try {
            new_libro.insertarLibro(libro);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean editarLibro() {
        return false;
    }

    public boolean eliminarLibro() {
        return false;
    }

}
