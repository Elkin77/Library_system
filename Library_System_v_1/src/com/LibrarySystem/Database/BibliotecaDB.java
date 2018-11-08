/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Biblioteca;
import com.LibrarySystem.Entities.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class BibliotecaDB {
    
    private static Connection cnx = null;
    
    public void insertarBiblioteca(Biblioteca new_biblioteca) throws SQLException{
        
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Biblioteca_Insert(?,?,?)}");
                procedure.setString("nombreIn", new_biblioteca.getNombre());
            procedure.setInt("num_librosIn", new_biblioteca.getNum_libros());
            procedure.setString("codigo_registroIn", new_biblioteca.getCodigo_registro());
            
            procedure.execute();
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
    public ArrayList<Biblioteca> obtenerAllBibliotecas() throws SQLException{ 
        ArrayList<Biblioteca> listBibliotecas = new ArrayList<>();
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Biblioteca_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            while(rs.next()){
                Biblioteca biblioteca = new Biblioteca(
                        rs.getInt("id_biblioteca"),
                        rs.getString("nombre"),
                        rs.getString("codigo_registro")
                );
                listBibliotecas.add(biblioteca);
            }
            
            //ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return listBibliotecas;
    }
    
}
