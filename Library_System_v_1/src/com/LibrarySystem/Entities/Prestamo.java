/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Prestamo {

    private int id_prestamo;
    private Date fecha_prestamo;
    private Date fecha_entrega;
    private int id_usuario;
    private int id_libro;
    private ArrayList<String> lista_libros;

    public Prestamo(int id_prestamo, Date fecha_prestamo, Date fecha_entrega, int id_usuario, int id_libro, ArrayList<String> lista_libros) {
        this.id_prestamo = id_prestamo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.lista_libros = lista_libros;
    }

    public Prestamo(Date fecha_prestamo, Date fecha_entrega, int id_usuario, int id_libro, ArrayList<String> lista_libros) {
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.lista_libros = lista_libros;
    }

    public Prestamo(Date fecha_prestamo, Date fecha_entrega, int id_usuario, int id_libro) {
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public ArrayList<String> getLista_libros() {
        return lista_libros;
    }

    public void setLista_libros(ArrayList<String> lista_libros) {
        this.lista_libros = lista_libros;
    }

    /*
    Estos Metodos a continuación realizaran las transacciones apuntando 
    a los procedimientos almacenados programados en el paquete 
    com.LibrarySystem.Database
     */
    public ArrayList<String> listarPrestamos() {

        return null;
    }

    public boolean registrarPrestamo() {
        return false;
    }

    public boolean editarPrestamo() {
        return false;
    }

    public boolean eliminarPrestamo() {
        return false;
    }

}
