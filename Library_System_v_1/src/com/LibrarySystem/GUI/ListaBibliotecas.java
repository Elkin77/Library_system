/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.GUI;

import com.LIbrarySystem.Componentes.Render;
import com.LibrarySystem.Database.BibliotecaDB;
import com.LibrarySystem.Database.UsuarioDB;
import com.LibrarySystem.Entities.Biblioteca;
import com.LibrarySystem.Entities.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author Acer
 */
public class ListaBibliotecas extends javax.swing.JFrame {

    /**
     * Creates new form GestionBiblioteca
     */
    
    String usuario;
    
    public ListaBibliotecas() {
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
        int column = tblBibliotecas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblBibliotecas.getRowHeight();
        
        if(row < tblBibliotecas.getRowCount() && row >= 0 &&
                column < tblBibliotecas.getColumnCount() && column >= 0){
            Object value = tblBibliotecas.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                if(boton.getName().equals("guardar")){
                    try {
                        //Aca va la logica al dar click en guardar
                        String nombre = (String) tblBibliotecas.getValueAt(row, 1);
                        String codigo_registro = (String) tblBibliotecas.getValueAt(row, 3);
                        int id_biblioteca =  (int) tblBibliotecas.getValueAt(row, 0);
                
                        
                        Biblioteca biblioteca = new Biblioteca(
                                id_biblioteca,
                                nombre,
                                codigo_registro

                        );
         
                        BibliotecaDB bibliotecaDB=new BibliotecaDB();
                        
                        bibliotecaDB.actualizarBiblioteca(biblioteca);
                        
                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ListaBibliotecas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }else{
                    //Aca va la logica al dar click en eliminar
                    int resp = JOptionPane.showConfirmDialog(null,
                            "¿Esta seguro que desea eliminar esta biblioteca?", 
                            "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(resp == 0){
                        try {
                            System.out.println(tblBibliotecas.getValueAt(row, 0));
                            int id_biblioteca = (int) tblBibliotecas.getValueAt(row, 0);
                            
                            BibliotecaDB bibliotecadb=new BibliotecaDB();
                            
                            bibliotecadb.eliminarBiblioteca(id_biblioteca);
                            
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
    
    
    
    
    public void cargarTabla ( ){
        try {
            tblBibliotecas.setDefaultRenderer(Object.class, new Render());
            DefaultTableModel modelo = new DefaultTableModel()
            {
                public boolean isCellEditable(int row, int column){
                    return (column == 0 || column == 2 || column >= 5)? false: true;
                }
            };
            
            ArrayList<Biblioteca> list_bibliotecas= new BibliotecaDB().obtenerAllBibliotecas();
            modelo.setColumnIdentifiers(new Object[]{"ID","Nombre","# Libros",
                "Codigo de Registro","Acción Editar","Acción Eliminar"});
            JButton btnEditar = new JButton("Guardar");
            btnEditar.setName("guardar");
            JButton btnEliminar = new JButton("Eliminar");
            btnEliminar.setName("eliminar");
            for (int i = 0; i < list_bibliotecas.size(); i++) {
                //cbRol.setSelectedIndex((lstUsuarios.get(i).getRol().equals("Usuario"))?0:1);
                
                Object[] bibliotecas = {
                    list_bibliotecas.get(i).getId_biblioteca(),
                    list_bibliotecas.get(i).getNombre(),
                    list_bibliotecas.get(i).getNum_libros(),
                    list_bibliotecas.get(i).getCodigo_registro(),
                    btnEditar,
                    btnEliminar
                };
                modelo.addRow(bibliotecas);
            }
            tblBibliotecas.setModel(modelo);
            
            
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
        tblBibliotecas = new javax.swing.JTable();
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

        tblBibliotecas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBibliotecas.setAlignmentX(1.0F);
        tblBibliotecas.setAlignmentY(1.0F);
        jScrollPane1.setViewportView(tblBibliotecas);

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
        lblTitulo1.setText("Gestionar Bibliotecas");

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
                        .addGap(0, 437, Short.MAX_VALUE))
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
                .addContainerGap(507, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atras1ActionPerformed
        // TODO add your handling code here:
        GestionarBiblioteca gestionar = new GestionarBiblioteca();
        gestionar.usuario = usuario;
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
        gestionarUsuario.usuario = usuario;
        gestionarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGestionarUsuarios1MouseClicked

    private void lblGestionarBibliotecas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarBibliotecas1MouseClicked
        // TODO add your handling code here:
        GestionarBiblioteca gestionar = new GestionarBiblioteca();
        gestionar.usuario = usuario;
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
            java.util.logging.Logger.getLogger(ListaBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaBibliotecas().setVisible(true);
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
    private javax.swing.JTable tblBibliotecas;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblTitulo;
}
