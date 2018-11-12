/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.Entities;

import com.LibrarySystem.Database.UsuarioDB;
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
        try {
            System.out.println("entrooo");
            lista_usuarios = new_session.obtenerAllUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean acceso = false;
        for (int i = 0; i < lista_usuarios.size(); i++) {

            if (usuario.equals(lista_usuarios.get(i).getUser())) {
                if (lista_usuarios.get(i).getPassword().equals(password)) {
                    System.out.println("correcto");
                    acceso = true;
                    if (lista_usuarios.get(i).getRol().equals("Administrador")) {
                        PaginaPrincipalAdmin ventana_admin = new PaginaPrincipalAdmin();
                        ventana_admin.setVisible(true);
                    } else {
                        PaginaPrincipalUsuario ventana_usuario = new PaginaPrincipalUsuario();
                        ventana_usuario.setVisible(true);
                    }

                } else {
                    acceso = false;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                    System.out.println("incorrecto");
                }
                break;
            } else {
                acceso = false;
                JOptionPane.showMessageDialog(null, "Este usuario no existe!");
                System.out.println("incorrecto");

            }
        }

        return true;
    }
}
