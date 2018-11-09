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
import java.sql.SQLException;

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

}
