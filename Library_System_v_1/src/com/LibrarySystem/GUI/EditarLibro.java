/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.GUI;

import com.LIbrarySystem.Componentes.Render;
import com.LibrarySystem.Database.CategoriaDB;
import com.LibrarySystem.Database.LibroDB;
import com.LibrarySystem.Entities.Categoria;
import com.LibrarySystem.Entities.Libro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class EditarLibro extends javax.swing.JFrame {

    /**
     * Creates new form EditarLibro
     */
    public EditarLibro() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarTabla();
    }

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {
        this.setState(JFrame.ICONIFIED);
    }

    private void tblBibliotecasMouseClicked(java.awt.event.MouseEvent evt) {
        int column = tblLibros.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblLibros.getRowHeight();

        if (row < tblLibros.getRowCount() && row >= 0
                && column < tblLibros.getColumnCount() && column >= 0) {
            Object value = tblLibros.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("guardar")) {
                    try {
                        //Aca va la logica al dar click en guardar
                        String nombre = (String) tblLibros.getValueAt(row, 1);
                        String descripcion = (String) tblLibros.getValueAt(row, 2);
                        String ubicacion = (String) tblLibros.getValueAt(row, 3);
                        String autor = (String) tblLibros.getValueAt(row, 4);
                        int id_libro = (int) tblLibros.getValueAt(row, 0);

                        Libro libro = new Libro(
                                id_libro,
                                nombre,
                                descripcion,
                                ubicacion,
                                autor
                                
                        );

                        LibroDB libritoDB = new LibroDB();

                        libritoDB.actualizarLibro(libro);

                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");

                    } catch (SQLException ex) {
                        Logger.getLogger(ListaBibliotecas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    //Aca va la logica al dar click en eliminar
                    int resp = JOptionPane.showConfirmDialog(null,
                            "¿Esta seguro que desea eliminar esta biblioteca?",
                            "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resp == 0) {
                        try {
                            System.out.println(tblLibros.getValueAt(row, 0));
                            int id_libro = (int) tblLibros.getValueAt(row, 0);
                            
                            LibroDB librodb = new LibroDB();

                            librodb.eliminarLibro(id_libro);

                            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");

                            cargarTabla();
                        } catch (SQLException ex) {
                            Logger.getLogger(ListaBibliotecas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
        }

    }

    public void cargarTabla() {
        try {
            tblLibros.setDefaultRenderer(Object.class, new Render());
            DefaultTableModel modelo = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return (column == 0 || column >= 6) ? false : true;
                }
            };

            ArrayList<Libro> list_libros = new LibroDB().obtenerAllLibros();
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Descripcion",
                "Ubicación", "Autor", "Portada", "Biblioteca", "Categoria", "Acción Editar", "Acción Eliminar"});
            JButton btnEditar = new JButton("Guardar");
            btnEditar.setName("guardar");
            JButton btnEliminar = new JButton("Eliminar");
            btnEliminar.setName("eliminar");
            for (int i = 0; i < list_libros.size(); i++) {
                //cbRol.setSelectedIndex((lstUsuarios.get(i).getRol().equals("Usuario"))?0:1);

                Object[] libros = {
                    list_libros.get(i).getId_libro(),
                    list_libros.get(i).getNombre(),
                    list_libros.get(i).getDescripcion(),
                    list_libros.get(i).getUbicacion(),
                    list_libros.get(i).getAutor(),
                    list_libros.get(i).getFoto(),
                    list_libros.get(i).getId_biblioteca(),
                    list_libros.get(i).getId_categoria(),
                    btnEditar,
                    btnEliminar
                };
                modelo.addRow(libros);
            }
            tblLibros.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(ListaBibliotecas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_atras1 = new javax.swing.JButton();
        pnlHeader1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblCerrar1 = new javax.swing.JLabel();
        lblMinimizar1 = new javax.swing.JLabel();
        lblGestionarUsuarios1 = new javax.swing.JLabel();
        lblGestionarBibliotecas1 = new javax.swing.JLabel();
        lblSalir1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLibros);

        jPanel1.setBackground(new java.awt.Color(239, 248, 248));

        btn_atras1.setText("Atras");
        btn_atras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atras1ActionPerformed(evt);
            }
        });

        pnlHeader1.setBackground(new java.awt.Color(23, 135, 137));
        pnlHeader1.setForeground(new java.awt.Color(239, 248, 248));

        lblTitulo1.setBackground(java.awt.Color.white);
        lblTitulo1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitulo1.setForeground(java.awt.Color.white);
        lblTitulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/LibrarySystem/Icons/users-white.png"))); // NOI18N
        lblTitulo1.setText("Gestionar Libro");

        lblCerrar1.setBackground(java.awt.Color.white);
        lblCerrar1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblCerrar1.setForeground(java.awt.Color.white);
        lblCerrar1.setText("X");
        lblCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseClicked(evt);
            }
        });

        lblMinimizar1.setBackground(java.awt.Color.white);
        lblMinimizar1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblMinimizar1.setForeground(java.awt.Color.white);
        lblMinimizar1.setText("-");
        lblMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizar1MouseClicked(evt);
            }
        });

        lblGestionarUsuarios1.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios1.setForeground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios1.setText("Gestionar Usuarios");
        lblGestionarUsuarios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuarios1MouseClicked(evt);
            }
        });

        lblGestionarBibliotecas1.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarBibliotecas1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarBibliotecas1.setForeground(new java.awt.Color(255, 255, 255));
        lblGestionarBibliotecas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarBibliotecas1.setText("Gestionar Bibliotecas");
        lblGestionarBibliotecas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarBibliotecas1MouseClicked(evt);
            }
        });

        lblSalir1.setBackground(new java.awt.Color(255, 255, 255));
        lblSalir1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblSalir1.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir1.setText("Salir");
        lblSalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeader1Layout.createSequentialGroup()
                        .addComponent(lblGestionarUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGestionarBibliotecas1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSalir1)
                        .addGap(0, 444, Short.MAX_VALUE))
                    .addGroup(pnlHeader1Layout.createSequentialGroup()
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMinimizar1)
                        .addGap(18, 18, 18)
                        .addComponent(lblCerrar1)
                        .addGap(22, 22, 22))))
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1)
                    .addComponent(lblCerrar1)
                    .addComponent(lblMinimizar1))
                .addGap(18, 18, 18)
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGestionarUsuarios1)
                    .addComponent(lblGestionarBibliotecas1)
                    .addComponent(lblSalir1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_atras1)
                .addGap(0, 513, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atras1ActionPerformed
        // TODO add your handling code here:
        GestionarBiblioteca gestionar = new GestionarBiblioteca();
        gestionar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_atras1ActionPerformed

    private void lblCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrar1MouseClicked

    private void lblMinimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizar1MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizar1MouseClicked

    private void lblGestionarUsuarios1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuarios1MouseClicked
        GestionarUsuarios gestionarUsuario = new GestionarUsuarios();
        gestionarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGestionarUsuarios1MouseClicked

    private void lblGestionarBibliotecas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarBibliotecas1MouseClicked
        // TODO add your handling code here:
        GestionarBiblioteca gestionar = new GestionarBiblioteca();
        gestionar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGestionarBibliotecas1MouseClicked

    private void lblSalir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalir1MouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if(resp == 0){
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_lblSalir1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar1;
    private javax.swing.JLabel lblGestionarBibliotecas1;
    private javax.swing.JLabel lblGestionarUsuarios1;
    private javax.swing.JLabel lblMinimizar1;
    private javax.swing.JLabel lblSalir1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblTitulo;
}
