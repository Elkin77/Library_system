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
            
            //ConectionDB.cerrar();
            
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
    
    public Biblioteca obtenerBibliotecaById(int idBiblioteca) throws SQLException{ 
        Biblioteca biblioteca;
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Biblioteca_SelectById(?)}");
            procedure.setInt("id_bibliotecaIn", idBiblioteca);
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            rs.next();
            
            biblioteca = new Biblioteca(
                        rs.getInt("id_biblioteca"),
                        rs.getString("nombre"),
                        rs.getString("codigo_registro")
                );
            
            
            //ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return biblioteca;
    }
    
    public void actualizarBiblioteca(Biblioteca b) throws SQLException{
        try{
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Biblioteca_Update(?,?,?)}");
            procedure.setString("nombreIn", b.getNombre());
            procedure.setString("codigo_registroIn", b.getCodigo_registro());
            procedure.setInt("idIn", b.getId_biblioteca());
            procedure.execute();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        finally{
            ConectionDB.cerrar();
        }
    }
    
    public void eliminarBiblioteca(int id_biblioteca) throws SQLException{
        try{
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Biblioteca_Delete(?)}");
            procedure.setInt("id_bibliotecaIn", id_biblioteca);
            
            procedure.execute();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
//        finally{
//            ConectionDB.cerrar();
//        }
    }
    
}
