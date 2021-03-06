/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LibrarySystem.GUI;

import com.LibrarySystem.Database.LibroDB;
import com.LibrarySystem.Database.PrestamoDB;
import com.LibrarySystem.Database.UsuarioDB;
import com.LibrarySystem.Entities.Libro;
import com.LibrarySystem.Entities.Prestamo;
import com.LibrarySystem.Entities.Seguridad;
import com.LibrarySystem.Entities.Usuario;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author brayan
 */
public class DetallesLibro extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    int idLibro;
    String usuario;
    
    public DetallesLibro() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void mostrarDetalle (){
        ArrayList<Libro> list_libro = new ArrayList<>();
        LibroDB libro = new  LibroDB ();
        try {
            list_libro = libro.obtenerLibroByLibro(idLibro);
            label_titulo.setText(list_libro.get(0).getNombre());
            lblDescripcion.setText(list_libro.get(0).getDescripcion());
            lblUbicacion.setText(list_libro.get(0).getUbicacion());
            lblCategoria.setText(list_libro.get(0).getId_categoria()+"");
            lblAutor.setText(list_libro.get(0).getAutor());
            
        } catch (SQLException ex) {
            Logger.getLogger(DetallesLibro.class.getName()).log(Level.SEVERE, null, ex);
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

        pnlBody = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblGestionarUsuarios2 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblGestionarUsuarios4 = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblGestionarUsuarios6 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblGestionarUsuarios8 = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        btnTomarPrestado = new javax.swing.JButton();
        pnlHeader1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblCerrar1 = new javax.swing.JLabel();
        lblMinimizar1 = new javax.swing.JLabel();
        lblGestionarUsuarios1 = new javax.swing.JLabel();
        lblGestionarBibliotecas1 = new javax.swing.JLabel();
        lblSalir1 = new javax.swing.JLabel();
        btn_atras1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBody.setBackground(new java.awt.Color(239, 248, 248));

        label_titulo.setBackground(new java.awt.Color(23, 135, 137));
        label_titulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(23, 135, 137));
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Titulo Libro");
        label_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_tituloMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        lblGestionarUsuarios2.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios2.setForeground(new java.awt.Color(23, 135, 137));
        lblGestionarUsuarios2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios2.setText("Descripción:");
        lblGestionarUsuarios2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuarios2MouseClicked(evt);
            }
        });

        lblDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(153, 0, 0));
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescripcion.setText("<html>Descripción del Libro</html>");
        lblDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDescripcionMouseClicked(evt);
            }
        });

        lblGestionarUsuarios4.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios4.setForeground(new java.awt.Color(23, 135, 137));
        lblGestionarUsuarios4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios4.setText("Ubicación:");
        lblGestionarUsuarios4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuarios4MouseClicked(evt);
            }
        });

        lblUbicacion.setBackground(new java.awt.Color(255, 255, 255));
        lblUbicacion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(153, 0, 0));
        lblUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUbicacion.setText("<html>Ubicación del Libro</html>");
        lblUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUbicacionMouseClicked(evt);
            }
        });

        lblGestionarUsuarios6.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios6.setForeground(new java.awt.Color(23, 135, 137));
        lblGestionarUsuarios6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios6.setText("Categorias:");
        lblGestionarUsuarios6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuarios6MouseClicked(evt);
            }
        });

        lblCategoria.setBackground(new java.awt.Color(255, 255, 255));
        lblCategoria.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(153, 0, 0));
        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCategoria.setText("<html>Categorias del Libro</html>");
        lblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCategoriaMouseClicked(evt);
            }
        });

        lblGestionarUsuarios8.setBackground(new java.awt.Color(255, 255, 255));
        lblGestionarUsuarios8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblGestionarUsuarios8.setForeground(new java.awt.Color(23, 135, 137));
        lblGestionarUsuarios8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionarUsuarios8.setText("Autor:");
        lblGestionarUsuarios8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGestionarUsuarios8MouseClicked(evt);
            }
        });

        lblAutor.setBackground(new java.awt.Color(255, 255, 255));
        lblAutor.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(153, 0, 0));
        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAutor.setText("<html>Autor del Libro</html>");
        lblAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAutorMouseClicked(evt);
            }
        });

        btnTomarPrestado.setBackground(new java.awt.Color(23, 165, 137));
        btnTomarPrestado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnTomarPrestado.setForeground(new java.awt.Color(255, 255, 255));
        btnTomarPrestado.setText("Tomar Prestado");
        btnTomarPrestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarPrestadoActionPerformed(evt);
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
                        .addGap(0, 456, Short.MAX_VALUE))
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

        btn_atras1.setText("Atras");
        btn_atras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGestionarUsuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGestionarUsuarios4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGestionarUsuarios6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGestionarUsuarios8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAutor)
                            .addComponent(lblCategoria)
                            .addComponent(lblUbicacion)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTomarPrestado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(pnlHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(766, 766, 766))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addComponent(pnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_atras1)
                .addGap(43, 43, 43)
                .addComponent(label_titulo)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestionarUsuarios2)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestionarUsuarios4)
                            .addComponent(lblUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestionarUsuarios6)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestionarUsuarios8)
                            .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73)))
                .addComponent(btnTomarPrestado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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

    private void label_tituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_tituloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label_tituloMouseClicked

    private void lblGestionarUsuarios2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuarios2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGestionarUsuarios2MouseClicked

    private void lblDescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescripcionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDescripcionMouseClicked

    private void lblGestionarUsuarios4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuarios4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGestionarUsuarios4MouseClicked

    private void lblUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUbicacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUbicacionMouseClicked

    private void lblGestionarUsuarios6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuarios6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGestionarUsuarios6MouseClicked

    private void lblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCategoriaMouseClicked

    private void lblGestionarUsuarios8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGestionarUsuarios8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGestionarUsuarios8MouseClicked

    private void lblAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAutorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAutorMouseClicked

    private void btnTomarPrestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPrestadoActionPerformed
        Usuario user;
        try {
            System.out.println("USUARIO ->" + usuario);
            user = new UsuarioDB().obtenerUsuarioByUser(usuario);
            Calendar tiempo = Calendar.getInstance();
            String horaActual = (tiempo.get(Calendar.YEAR)+ "-" + (tiempo.get(Calendar.MONTH) + 1) + "-" + tiempo.get(Calendar.DATE));
            Prestamo prestamo = new Prestamo(horaActual, horaActual, user.getIdUsuario(),idLibro);
            JOptionPane.showMessageDialog(null, "el user es, "+ user.getIdUsuario() + "el libro es: " + idLibro);
            new PrestamoDB().insertarPrestamo(prestamo);
            
            JOptionPane.showMessageDialog(null, "Prestamo registrado correctamente");
            
            if(user.getRol().equals("Usuario")){
                PaginaPrincipalUsuario pagPrincipalUsuario = new PaginaPrincipalUsuario();
                pagPrincipalUsuario.setVisible(true);
                this.dispose();
            }else{
                PaginaPrincipalAdmin pagPrincipalAdmin = new PaginaPrincipalAdmin();
                pagPrincipalAdmin.setVisible(true);
                pagPrincipalAdmin.usuario = usuario;
                this.dispose();
            }
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(DetallesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTomarPrestadoActionPerformed

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

    private void btn_atras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atras1ActionPerformed
        // TODO add your handling code here:
        GestionarBiblioteca gestionar = new GestionarBiblioteca();
        gestionar.usuario = usuario;
        gestionar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_atras1ActionPerformed

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
            java.util.logging.Logger.getLogger(DetallesLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetallesLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTomarPrestado;
    private javax.swing.JButton btn_atras1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCerrar1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblGestionarBibliotecas1;
    private javax.swing.JLabel lblGestionarUsuarios1;
    private javax.swing.JLabel lblGestionarUsuarios2;
    private javax.swing.JLabel lblGestionarUsuarios4;
    private javax.swing.JLabel lblGestionarUsuarios6;
    private javax.swing.JLabel lblGestionarUsuarios8;
    private javax.swing.JLabel lblMinimizar1;
    private javax.swing.JLabel lblSalir1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader1;
    // End of variables declaration//GEN-END:variables
}
