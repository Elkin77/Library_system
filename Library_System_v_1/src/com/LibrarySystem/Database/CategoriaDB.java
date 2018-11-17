/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.LibrarySystem.Entities.Biblioteca;
import com.LibrarySystem.Entities.Categoria;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

            //ConectionDB.cerrar();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }
    
    public ArrayList<Categoria> obtenerAllCategorias() throws SQLException{ 
        ArrayList<Categoria> listCategorias = new ArrayList<>();
        try{
            cnx = ConectionDB.obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Categoria_SelectAll()}");
            procedure.execute();
            ResultSet rs = procedure.getResultSet();
            
            while(rs.next()){
                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_registro"),
                        rs.getInt("id_biblioteca")
                );
                listCategorias.add(categoria);
            }
            
            //ConectionDB.cerrar();
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return listCategorias;
    }
    
        public void actualizarCategoria(Categoria c) throws SQLException{
        try{
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Categoria_Update(?,?,?,?)}");
            procedure.setString("nombreIn", c.getNombre());
            procedure.setString("descripcionIn", c.getDescripcion());
            procedure.setString("codigo_registroIn", c.getCodigo_registro());
            procedure.setInt("idIn", c.getId_categoria());
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
    
    public void eliminarCategoria(int id_categoria) throws SQLException{
        try{
            cnx = new ConectionDB().obtener();
            CallableStatement procedure = cnx.prepareCall("{call PA_Categoria_Delete(?)}");
            procedure.setInt("id_categoriaIn", id_categoria);
            
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
