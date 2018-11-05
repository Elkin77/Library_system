/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author brayan
 */
public class UsuarioDB {
    
    private static Connection cnx = null;
    
    public void insertarUsuario(Usuario u) throws SQLException{
        
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Usuario_Insert(?,?,?,?,?)}");
            procedure.setString("nombreIn", u.getNombre());
            procedure.setString("userIn", u.getUser());
            procedure.setString("passwordIn", u.getPassword());
            procedure.setString("nombre_comunidadIn", u.getNombreComunidad());
            procedure.setString("rolIn", u.getRol());
            
            procedure.execute();
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
    
    public void actualizarUsuario(Usuario u) throws SQLException{
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Usuario_Update(?,?,?,?,?,?)}");
            procedure.setInt("id_userIn", u.getIdUsuario());
            procedure.setString("nombreIn", u.getNombre());
            procedure.setString("userIn", u.getUser());
            procedure.setString("passwordIn", u.getPassword());
            procedure.setString("nombre_comunidadIn", u.getNombreComunidad());
            procedure.setString("rolIn", u.getRol());
            
            procedure.execute();
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
    
    public ArrayList<Usuario> obtenerAllUsuarios() throws SQLException{ 
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Usuario_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("nombre_comunidad"),
                        rs.getString("rol")
                );
                lstUsuarios.add(usuario);
            }
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return lstUsuarios;
    }
    
    public Usuario obtenerUsuarioByUser(String user) throws SQLException{
        Usuario usuario = new Usuario();
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Usuario_SelectByUser(?)}");
            procedure.setString("userIn", user);
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            while(rs.next()){
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("nombre_comunidad"),
                        rs.getString("rol")
                );
            }
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return usuario;
    }
    
    public void eliminarUsuario(String user) throws SQLException{
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Usuario_Delete(?)}");
            procedure.setString("userIn", user);
            
            procedure.execute();
            
            ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
    }
}
