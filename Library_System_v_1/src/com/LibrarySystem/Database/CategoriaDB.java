/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Categoria;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class CategoriaDB {

    private static Connection cnx = null;

    public void insertarCategoria(Categoria new_categoria) throws SQLException {
            System.out.println(new_categoria.getNombre());
            System.out.println(new_categoria.getDescripcion());
            System.out.println(new_categoria.getCodigo_registro());
            System.out.println(new_categoria.getId_biblioteca());
        try {
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Categoria_Insert(?,?,?,?)}");
            procedure.setString("nombreIn", new_categoria.getNombre());
            procedure.setString("descripcionIn", new_categoria.getDescripcion());
            procedure.setString("codigo_registroIn", new_categoria.getCodigo_registro());
            procedure.setInt("id_bibliotecaIn", new_categoria.getId_biblioteca());
            procedure.execute();

            ConectionDB.cerrar();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }

}
