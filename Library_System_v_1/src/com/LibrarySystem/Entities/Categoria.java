/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import com.LibrarySystem.Database.BibliotecaDB;
import com.LibrarySystem.Database.CategoriaDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Categoria {

    private int id_categoria;
    private String nombre;
    private String descripcion;
    private String codigo_registro;
    private int id_biblioteca;
    private ArrayList<String> lista_temas;
    private ArrayList<String> lista_libros;

    public Categoria(int id_categoria, String nombre, String descripcion, String codigo_registro, ArrayList<String> lista_temas, ArrayList<String> lista_libros) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_registro = codigo_registro;
        this.lista_temas = lista_temas;
        this.lista_libros = lista_libros;
    }

    public Categoria(String nombre, String descripcion, String codigo_registro, ArrayList<String> lista_temas, ArrayList<String> lista_libros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_registro = codigo_registro;
        this.lista_temas = lista_temas;
        this.lista_libros = lista_libros;
    }

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre, String descripcion, String codigo_registro, int id_biblioteca) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_registro = codigo_registro;
        this.id_biblioteca = id_biblioteca;
    }

    public Categoria(int id_categoria, String nombre, String descripcion, String codigo_registro) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_registro = codigo_registro;
    }

    public Categoria(int id_categoria, String nombre, String codigo_registro) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.codigo_registro = codigo_registro;
    }

    public Categoria(String nombre, String descripcion, String codigo_registro, int id_biblioteca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_registro = codigo_registro;
        this.id_biblioteca = id_biblioteca;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public String getCodigo_registro() {
        return codigo_registro;
    }

    public void setCodigo_registro(String codigo_registro) {
        this.codigo_registro = codigo_registro;
    }

    public ArrayList<String> getLista_temas() {
        return lista_temas;
    }

    public void setLista_temas(ArrayList<String> lista_temas) {
        this.lista_temas = lista_temas;
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
    public ArrayList<Categoria> listarCategorias() {
        ArrayList<Categoria> listCategorias = new ArrayList<>();
        CategoriaDB categoriadb = new CategoriaDB();
        try {
            listCategorias = categoriadb.obtenerAllCategorias();
            return listCategorias;

        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Categoria> listarCategoriasBiblioteca(int id_biblioteca) {
        ArrayList<Categoria> listCategorias = new ArrayList<>();
        CategoriaDB categoriadb = new CategoriaDB();
        try {
            listCategorias = categoriadb.obtenerCategoriasBiblioteca(id_biblioteca);
            return listCategorias;

        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean registrarCategoria(Categoria categoria) {
        try {
            CategoriaDB categoriadb = new CategoriaDB();
            categoriadb.insertarCategoria(categoria);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean editarCategoria() {
        return false;
    }

    public boolean eliminarCategoria() {
        return false;
    }

}
