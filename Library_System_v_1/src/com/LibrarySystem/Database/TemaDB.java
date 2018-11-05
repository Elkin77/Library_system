/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Tema;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author brayan
 */
public class TemaDB {
    private static Connection cnx = null;
    
    public void insertarTema(Tema tema) throws SQLException{
        
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Tema_Insert(?,?,?,?)}");
            procedure.setString("nombreIn", tema.getNombre());
            procedure.setString("descripcionIn", tema.getDescripcion());
            procedure.setString("codigo_registroIn", tema.getCodigoRegistro());
            procedure.setInt("id_categoriaIn", tema.getIdCategoria());
            
            procedure.execute();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
    
    public void actualizarTema(Tema tema) throws SQLException{
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Tema_Update(?,?,?,?,?)}");
            procedure.setInt("id_temaIn", tema.getIdTema());
            procedure.setString("nombreIn", tema.getNombre());
            procedure.setString("descripcionIn", tema.getDescripcion());
            procedure.setString("codigo_registroIn", tema.getCodigoRegistro());
            procedure.setInt("id_categoriaIn", tema.getIdCategoria());
            
            procedure.execute();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
    
    public ArrayList<Tema> obtenerAllTemas() throws SQLException{ 
        ArrayList<Tema> lstTemas = new ArrayList<>();
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Temas_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            while(rs.next()){
                Tema tema = new Tema(
                        rs.getInt("id_tema"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_registro"),
                        rs.getInt("id_categoria")
                );
                lstTemas.add(tema);
            }
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return lstTemas;
    }
    
    public void eliminarTema(int id_tema) throws SQLException{
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Tema_Delete(?)}");
            procedure.setInt("id_temaIn", id_tema);
            
            procedure.execute();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
}
