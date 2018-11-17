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
        initComponent();
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarTabla();
    }

    public void initComponent() {
        pnlBody = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();

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

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "NOMBRE", "NUMERO DE LIBROS", "CODIGO DE REGISTRO", "", ""
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                true, false, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBibliotecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibros);

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
                        Logger.getLogger(GestionBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(GestionBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
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
        tblLibros = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblTitulo;
}
