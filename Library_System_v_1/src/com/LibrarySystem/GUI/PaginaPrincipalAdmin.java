/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.GUI;

import com.LIbrarySystem.Componentes.Render;
import com.LibrarySystem.Database.BibliotecaDB;
import com.LibrarySystem.Database.CategoriaDB;
import com.LibrarySystem.Database.LibroDB;
import com.LibrarySystem.Entities.Biblioteca;
import com.LibrarySystem.Entities.Categoria;
import com.LibrarySystem.Entities.Libro;
import com.LibrarySystem.Entities.Seguridad;
import com.LibrarySystem.Entities.Usuario;
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
 * @author brayan
 */
public class PaginaPrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    public String usuario;
    
    public PaginaPrincipalAdmin() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        ArrayList<Libro> list_libros = new ArrayList<Libro>();
        try {
            list_libros = new LibroDB().obtenerAllLibros();
        } catch (SQLException ex) {
            Logger.getLogger(PaginaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarTabla(list_libros);
        cargarComboBox();
    }
    
    private void cargarComboBox(){
        ArrayList<Biblioteca> lstBibliotecas;
        ArrayList<Categoria> lstCategorias;
        try {
            lstBibliotecas = new BibliotecaDB().obtenerAllBibliotecas();
            lstCategorias = new CategoriaDB().obtenerAllCategorias();
            cbBiblioteca.removeAllItems();
            cbCategoria.removeAllItems();
            for (int i = 0; i < lstBibliotecas.size(); i++) {
                cbBiblioteca.addItem(lstBibliotecas.get(i).getId_biblioteca() + " " + lstBibliotecas.get(i).getNombre());
            }
            for (int i = 0; i < lstCategorias.size(); i++) {
                cbCategoria.addItem(lstCategorias.get(i).getId_categoria() + " " + lstCategorias.get(i).getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaginaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarTabla(ArrayList<Libro> list_libros) {
        tbl_libros.removeAll();
        tbl_libros.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return (column >= 0) ? false : true;
            }
        };
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Descripcion",
            "Ubicación", "Autor", "Portada", "Biblioteca", "Categoria", "Acción"});
        JButton btnVerMas = new JButton("Ver Más");
        btnVerMas.setName("ver_mas");
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
                btnVerMas,
            };
            modelo.addRow(libros);
        }
        tbl_libros.setModel(modelo);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBody = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblGestionarUsuarios = new javax.swing.JLabel();
        lblGestionarBibliotecas = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_libros = new javax.swing.JTable();
        cbBiblioteca = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBody.setBackground(new java.awt.Color(239, 248, 248));

        pnlHeader.setBackground(new java.awt.Color(23, 135, 137));

        lblCerrar.setBackground(java.awt.Color.white);
        lblCerrar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblCerrar.setForeground(java.awt.Color.white);
        lblCerrar.setText("X");
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblMinimizar.setBackground(java.awt.Color.white);
        lblMinimizar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblMinimizar.setForeground(java.awt.Color.white);
        lblMinimizar.setText("-");
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblGestionarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios.setText("Gestionar Usuarios");
        lblGestionarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuariosMouseClicked(evt);
            }
        });

        lblGestionarBibliotecas.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarBibliotecas.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarBibliotecas.setForeground(new java.awt.Color(255, 255, 255));
        lblGestionarBibliotecas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarBibliotecas.setText("Gestionar Bibliotecas");
        lblGestionarBibliotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarBibliotecasMouseClicked(evt);
            }
        });

        lblSalir.setBackground(new java.awt.Color(255, 255, 255));
        lblSalir.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("Salir");
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        lblTitulo.setBackground(java.awt.Color.white);
        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitulo.setForeground(java.awt.Color.white);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/LibrarySystem/Icons/user-white.png"))); // NOI18N
        lblTitulo.setText("Administrador");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGestionarBibliotecas, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(652, 652, 652)
                        .addComponent(lblMinimizar)
                        .addGap(18, 18, 18)
                        .addComponent(lblCerrar)
                        .addGap(22, 22, 22))))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCerrar)
                    .addComponent(lblMinimizar)
                    .addComponent(lblTitulo))
                .addGap(18, 18, 18)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGestionarUsuarios)
                    .addComponent(lblGestionarBibliotecas)
                    .addComponent(lblSalir))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tbl_libros.setBackground(new java.awt.Color(239, 248, 248));
        tbl_libros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_libros.setForeground(new java.awt.Color(23, 135, 137));
        tbl_libros.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_libros.setGridColor(new java.awt.Color(23, 135, 137));
        tbl_libros.setSelectionBackground(new java.awt.Color(23, 135, 137));
        tbl_libros.setSelectionForeground(new java.awt.Color(239, 248, 248));
        tbl_libros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_librosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_libros);

        cbBiblioteca.setBackground(new java.awt.Color(255, 255, 255));
        cbBiblioteca.setForeground(new java.awt.Color(0, 0, 0));
        cbBiblioteca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));

        cbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoria.setForeground(new java.awt.Color(0, 0, 0));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));

        btnBuscar.setBackground(new java.awt.Color(23, 135, 137));
        btnBuscar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addComponent(cbBiblioteca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(txtSearch)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblGestionarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuariosMouseClicked
        GestionarUsuarios gestionarUsuario = new GestionarUsuarios();
        gestionarUsuario.setVisible(true);
        gestionarUsuario.usuario = usuario;
        this.dispose();
    }//GEN-LAST:event_lblGestionarUsuariosMouseClicked

    private void lblGestionarBibliotecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarBibliotecasMouseClicked
        // TODO add your handling code here:
        
            GestionarBiblioteca gestionar = new GestionarBiblioteca();
            gestionar.usuario = usuario;
            gestionar.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_lblGestionarBibliotecasMouseClicked

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if(resp == 0){
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblSalirMouseClicked

    private void tbl_librosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_librosMouseClicked
        JOptionPane.showMessageDialog(null, "Llegue!");
        int column = tbl_libros.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbl_libros.getRowHeight();

        if (row < tbl_libros.getRowCount() && row >= 0
                && column < tbl_libros.getColumnCount() && column >= 0) {
            Object value = tbl_libros.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("ver_mas")) {
                    // para agregar logica
                    DetallesLibro libro = new DetallesLibro();
                    libro.idLibro = (int) tbl_libros.getValueAt(row, 0);
                    libro.usuario = usuario;
                    libro.mostrarDetalle();
                    libro.setVisible(true);
                    this.dispose();

                } 
            }
        }
    }//GEN-LAST:event_tbl_librosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        int idBiblioteca = Integer.parseInt(cbBiblioteca.getSelectedItem().toString().split(" ")[0]);
        int idCategoria = Integer.parseInt(cbCategoria.getSelectedItem().toString().split(" ")[0]);
        try {
            ArrayList<Libro> lstLibros = new LibroDB().obtenerLibroByParameters(idBiblioteca, idCategoria, txtSearch.getText());
            cargarTabla(lstLibros);
        } catch (SQLException ex) {
            Logger.getLogger(PaginaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

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
            java.util.logging.Logger.getLogger(PaginaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbBiblioteca;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGestionarBibliotecas;
    private javax.swing.JLabel lblGestionarUsuarios;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTable tbl_libros;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
