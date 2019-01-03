/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Libro;
import com.LibrarySystem.Entities.Prestamo;
import com.mysql.jdbc.Connection;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author braya
 */
public class PrestamoDB {
    
    private static Connection cnx = null;
    
    
    public void insertarPrestamo(Prestamo prestamo) throws SQLException{
        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Prestamo_Insert(?,?,?,?)}");
            procedure.setString("fecha_prestamoIn", prestamo.getFecha_prestamo());
            procedure.setString("fecha_entregaIn", prestamo.getFecha_entrega());
            procedure.setInt("id_usuarioIn", prestamo.getId_usuario());
            procedure.setInt("id_libroIn", prestamo.getId_libro());

            procedure.execute();

            ConectionDB.cerrar();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }
    
    public ArrayList<Prestamo> obtenerAllPrestamos() throws SQLException{
        ArrayList<Prestamo> listPrestamos = new ArrayList<>();
        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Prestamo_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                        rs.getInt("id_prestamo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_entrega"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_prestamo")
                );
                listPrestamos.add(prestamo);
            }

            //ConectionDB.cerrar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
        return listPrestamos;
    }
    
    public ArrayList<Prestamo> obtenerPrestamosByUser(String user) throws SQLException{
        ArrayList<Prestamo> listPrestamos = new ArrayList<>();
        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Prestamo_SelectByUser(?)}");
            procedure.setString("userIn", user);
            procedure.execute();
            ResultSet rs = procedure.getResultSet();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                        rs.getInt("id_prestamo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_entrega"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_prestamo")
                );
                listPrestamos.add(prestamo);
            }

            //ConectionDB.cerrar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
        return listPrestamos;
    }
    
    public void actualizarPrestamo(Prestamo prestamo) throws SQLException{
        try {
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Prestamo_Update(?,?,?,?,?)}");
            procedure.setInt("id_prestamoIn", prestamo.getId_prestamo());
            procedure.setString("fecha_prestamoIn",prestamo.getFecha_prestamo());
            procedure.setString("fecha_entregaIn",prestamo.getFecha_entrega());
            procedure.setInt("id_usuarioIn", prestamo.getId_usuario());
            procedure.setInt("id_libroIn", prestamo.getId_libro());
            procedure.execute();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        } finally {
            ConectionDB.cerrar();
        }
    }
    
    public void eliminarPrestamo(int idPrestamo) throws SQLException{
        try {
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Libro_Delete(?)}");
            procedure.setInt("id_PrestamoIn", idPrestamo);

            procedure.execute();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }
    
}
