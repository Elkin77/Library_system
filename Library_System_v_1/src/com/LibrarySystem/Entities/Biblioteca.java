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
public class Biblioteca {

    private int id_biblioteca;
    private String nombre;
    private int num_libros;
    private ArrayList<String> lista_libros;
    private ArrayList<String> lista_categorias;

    public Biblioteca(int id_biblioteca, String nombre, int num_libros, ArrayList<String> lista_libros, ArrayList<String> lista_categorias) {
        this.id_biblioteca = id_biblioteca;
        this.nombre = nombre;
        this.num_libros = num_libros;
        this.lista_libros = lista_libros;
        this.lista_categorias = lista_categorias;
    }

    public Biblioteca(String nombre, int num_libros, ArrayList<String> lista_libros, ArrayList<String> lista_categorias) {
        this.nombre = nombre;
        this.num_libros = num_libros;
        this.lista_libros = lista_libros;
        this.lista_categorias = lista_categorias;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_libros() {
        return num_libros;
    }

    public void setNum_libros(int num_libros) {
        this.num_libros = num_libros;
    }

    public ArrayList<String> getLista_libros() {
        return lista_libros;
    }

    public void setLista_libros(ArrayList<String> lista_libros) {
        this.lista_libros = lista_libros;
    }

    public ArrayList<String> getLista_categorias() {
        return lista_categorias;
    }

    public void setLista_categorias(ArrayList<String> lista_categorias) {
        this.lista_categorias = lista_categorias;
    }

    /*
    Estos Metodos a continuación realizaran las transacciones apuntando 
    a los procedimientos almacenados programados en el paquete 
    com.LibrarySystem.Database
     */
    public ArrayList<String> listarBibliotecas() {

        return null;
    }

    public boolean registrarBiblioteca() {
        return false;
    }

    public boolean editarBiblioteca() {
        return false;
    }

    public boolean eliminarBiblioteca() {
        return false;
    }

}
