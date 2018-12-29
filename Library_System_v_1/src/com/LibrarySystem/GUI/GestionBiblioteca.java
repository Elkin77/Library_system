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
public class GestionBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form GestionBiblioteca
     */
    
    String usuario;
    
    public GestionBiblioteca() {
        initComponent();
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarTabla();
    }
    
    public void initComponent(){
        pnlBody = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBibliotecas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBody.setBackground(new java.awt.Color(44, 62, 80));

        pnlHeader.setBackground(new java.awt.Color(248, 148, 6));

        lblTitulo.setBackground(java.awt.Color.white);
        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitulo.setForeground(java.awt.Color.white);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/LibrarySystem/Icons/users-white.png"))); // NOI18N
        lblTitulo.setText("Gestión de Bibliotecas");

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

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimizar)
                .addGap(18, 18, 18)
                .addComponent(lblCerrar)
                .addGap(22, 22, 22))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblCerrar)
                    .addComponent(lblMinimizar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblBibliotecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "NUMERO DE LIBROS", "CODIGO DE REGISTRO", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBibliotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBibliotecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBibliotecas);

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(303, 303, 303))
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
                        Logger.getLogger(GestionBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(GestionBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestionBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionBiblioteca().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBibliotecas;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblTitulo;
}
