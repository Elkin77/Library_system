/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Database;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brayan
 */
public class ConectionDB {
    
   private static Connection cnx = null;
   
   public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SystemLibrary", "brayan", "uniminuto");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
   
   
//   public Object insertar(ArrayList<Object> listParam, String nameStoreProcedure){
//       //crear el llamado del procedimiento
//       String sql = "{call "+nameStoreProcedure + "("+contarCampos(listParam.size(), "")+")}";
//       try{
//           //obtener la conexion
//           obtener();
//           
//           //llamar al procedimiento
//           CallableStatement cst = cnx.prepareCall(sql);
//           
//           //parametros de entrada, si hay
//           for (int i = 0; i < listParam.size(); i++) {
//               cst.setString(i, listParam.get(i).toString());
//           }
//           
//           //ejecutar el procedimiento
//           cst.execute();
//           
//           
//       }catch(SQLException ex){
//           
//       } catch (ClassNotFoundException ex) {
//           Logger.getLogger(ConectionDB.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       for (int i = 0; i < listParam.size(); i++) {
//           
//       }
//       return null;
//   }
//   
//   private String contarCampos(int size, String salida){
//       if(size <= 1){
//           contarCampos((size-1),(salida+"?,"));
//           return "";
//       }else{
//           return salida;
//       }
//   }
    
}
