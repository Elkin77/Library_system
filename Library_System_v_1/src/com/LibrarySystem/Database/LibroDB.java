/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Biblioteca;
import com.LibrarySystem.Entities.Libro;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class LibroDB {

    private static Connection cnx = null;

    public void insertarLibro(Libro new_libro) throws SQLException {

        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Libro_Insert(?,?,?,?,?,?,?)}");
            procedure.setString("nombreIn", new_libro.getNombre());
            procedure.setString("descripcionIn", new_libro.getDescripcion());
            procedure.setString("ubicacionIn", new_libro.getUbicacion());
            procedure.setString("autorIn", new_libro.getAutor());
            procedure.setString("fotoIn", new_libro.getFoto());
            procedure.setInt("id_bibliotecaIn", new_libro.getId_biblioteca());
            procedure.setInt("id_categoriaIn", new_libro.getId_categoria());

            procedure.execute();

            ConectionDB.cerrar();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }

    public ArrayList<Libro> obtenerAllLibros() throws SQLException {
        ArrayList<Libro> listlibros = new ArrayList<>();
        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Libro_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("ubicacion"),
                        rs.getString("autor"),
                        rs.getString("foto"),
                        rs.getInt("id_biblioteca"),
                        rs.getInt("id_categoria")
                );
                listlibros.add(libro);
            }

            //ConectionDB.cerrar();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
        return listlibros;
    }

    public void actualizarLibro(Libro l) throws SQLException {
        try {
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Libro_Update(?,?,?,?,?)}");
            procedure.setString("nombreIn", l.getNombre());
            procedure.setString("descripcionIn", l.getDescripcion());
            procedure.setString("ubicacionIn", l.getUbicacion());
            procedure.setString("autorIn", l.getAutor());
            procedure.setInt("idIn", l.getId_libro());
            procedure.execute();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        } finally {
            ConectionDB.cerrar();
        }
    }

    public void eliminarLibro(int id_libro) throws SQLException {
        
        try {
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Libro_Delete(?)}");
            procedure.setInt("id_libroIn", id_libro);

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
