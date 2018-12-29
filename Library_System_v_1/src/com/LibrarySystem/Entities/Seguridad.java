/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import com.LibrarySystem.Database.UsuarioDB;
import com.LibrarySystem.GUI.Login;
import com.LibrarySystem.GUI.PaginaPrincipalAdmin;
import com.LibrarySystem.GUI.PaginaPrincipalUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Seguridad {

    public boolean iniciar_sesion(String usuario, String password) {
        ArrayList<Usuario> lista_usuarios = new ArrayList<>();
        UsuarioDB new_session = new UsuarioDB();
        int validador_user = 0;
        try {
            System.out.println("entrooo");
            lista_usuarios = new_session.obtenerAllUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean acceso = false;
        for (int i = 0; i < lista_usuarios.size(); i++) {
            System.out.println("usuario ingresado: "+ usuario + "Usuario en arreglo: "+lista_usuarios.get(i).getUser());
            if (usuario.equals(lista_usuarios.get(i).getUser())) {
                validador_user = 1;
                if (lista_usuarios.get(i).getPassword().equals(password)) {
                    System.out.println("correcto");
                    acceso = true;
                    if (lista_usuarios.get(i).getRol().equals("Administrador")) {
                        PaginaPrincipalAdmin ventana_admin = new PaginaPrincipalAdmin();
                        ventana_admin.setVisible(true);
                        ventana_admin.usuario = lista_usuarios.get(i).getUser();
                        break;
                    } else {
                        PaginaPrincipalUsuario ventana_usuario = new PaginaPrincipalUsuario();
                        ventana_usuario.setVisible(true);
                        ventana_usuario.usuario = lista_usuarios.get(i).getUser();
                        break;
                    }

                } else {
                    acceso = false;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                    System.out.println("incorrecto");
                    break;
                }
               
            }
            if(lista_usuarios.size()-1 == i && validador_user == 0) {
                acceso = false;
                JOptionPane.showMessageDialog(null, "Este usuario no existe!");
                System.out.println("incorrecto");
                //Login recargar = new Login();
                //recargar.setVisible(true);
            }
        }

        return acceso;
    }
}
