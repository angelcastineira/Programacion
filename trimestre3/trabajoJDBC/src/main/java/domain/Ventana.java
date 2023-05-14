package domain;

import datos.RegistrosTotales;
import datos.PersonaDAO;
import domain.Persona;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ubuntu
 */
import java.util.*;
public class Ventana extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

//Agregar el panel a la interfaz
    /**
     * Creates new form NewJFrame
     */
    //Persona persona;
    PersonaDAO personaDAO = new PersonaDAO();
    RegistrosTotales o = new RegistrosTotales();
    Integer i = 0;
    public Ventana() {
        initComponents();
        String[] titulo = new String[]{"Numero", "Nombre", "Apellido", "Importe", "Detalles"};
        dtm.setColumnIdentifiers(titulo);
        //mostrar registros anteriores
        List<Persona> personas = personaDAO.seleccionar();
        List<Integer> listaNumeros = personaDAO.identificacionPersona();
//        for(Persona persona : personas){
//            dtm.addRow(new Object{"x",persona.getNombre(),persona.getApellido(),persona.getImporte(),persona.getDetalles()});
//        }
        
        personas.forEach((lista) -> {
            
            
            Integer numero = listaNumeros.get(i);
            String nombre = lista.getNombre();
            String apellido = lista.getApellido();
            Integer importe = lista.getImporte();
            String detalles = lista.getDetalles();
            dtm.addRow(new Object[]{numero, nombre, apellido, importe, detalles});
            i++;
        });
        tblDatos.setModel(dtm);

    }

    void agregar() {
        //this.persona = new Persona(campoNombre.getText(),campoApellido.getText(),Integer.parseInt(campoImporte.getText()),campoDetalles.getText());
        //dtm.addRow(new Object[]{null,persona.getNombre(),persona.getApellido(),persona.getImporte(),persona.getDetalles()});
        try {
            
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            Integer importe = Integer.parseInt(campoImporte.getText());
            String detalles = campoDetalles.getText();
            //dtm.addRow(new Object[]{,nombre, apellido, importe, detalles});
            PersonaDAO pd = new PersonaDAO();
            Persona persona = new Persona(nombre, apellido, importe, detalles);
            pd.insertar(persona);
            i++;
            dtm.addRow(new Object[]{i,nombre, apellido, importe, detalles});
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Alguno de los campos no tiene el formato adecuado");
        }

    }

    void eliminar() {
        int fila = tblDatos.getSelectedRow();
        Integer valor = (Integer)tblDatos.getValueAt(fila, 0);
        dtm.removeRow(fila);
        
        personaDAO.borrar(valor);
        
        
    }

    void actualizar() {
        int fila = tblDatos.getSelectedRow();
        //dtm.setValueAt("s", fila, 0);
        dtm.setValueAt(campoNombre.getText(), fila, 1);
        dtm.setValueAt(campoApellido.getText(), fila, 2);
        dtm.setValueAt(campoImporte.getText(), fila, 3);
        dtm.setValueAt(campoDetalles.getText(), fila, 4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaApellido = new javax.swing.JLabel();
        etiquetaImporte = new javax.swing.JLabel();
        etiquetaDetalles = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoImporte = new javax.swing.JTextField();
        campoDetalles = new javax.swing.JTextField();
        campoApellido = new javax.swing.JTextField();
        bAniadir = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        bActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(153, 204, 255));
        panel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REGISTRO PERSONAS QUE HAN PAGADO");

        etiquetaNombre.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaNombre.setText("Nombre:");

        etiquetaApellido.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaApellido.setText("Apellido:");

        etiquetaImporte.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaImporte.setText("Importe:");

        etiquetaDetalles.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaDetalles.setText("Detalles:");

        campoNombre.setBackground(new java.awt.Color(255, 255, 255));
        campoNombre.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        campoImporte.setBackground(new java.awt.Color(255, 255, 255));
        campoImporte.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoImporte.setForeground(new java.awt.Color(0, 0, 0));
        campoImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoImporteActionPerformed(evt);
            }
        });

        campoDetalles.setBackground(new java.awt.Color(255, 255, 255));
        campoDetalles.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoDetalles.setForeground(new java.awt.Color(0, 0, 0));
        campoDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDetallesActionPerformed(evt);
            }
        });

        campoApellido.setBackground(new java.awt.Color(255, 255, 255));
        campoApellido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoApellido.setForeground(new java.awt.Color(0, 0, 0));
        campoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidoActionPerformed(evt);
            }
        });

        bAniadir.setBackground(new java.awt.Color(0, 204, 51));
        bAniadir.setForeground(new java.awt.Color(0, 0, 0));
        bAniadir.setText("Añadir");
        bAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAniadirActionPerformed(evt);
            }
        });

        bEliminar.setBackground(new java.awt.Color(255, 51, 51));
        bEliminar.setForeground(new java.awt.Color(0, 0, 0));
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        bLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatos);

        bActualizar.setBackground(new java.awt.Color(204, 204, 204));
        bActualizar.setForeground(new java.awt.Color(0, 0, 0));
        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(bAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEliminar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaNombre)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaApellido)
                                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaImporte)
                                    .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaDetalles)
                                    .addComponent(campoDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaApellido)
                    .addComponent(etiquetaImporte)
                    .addComponent(etiquetaDetalles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAniadir)
                    .addComponent(bLimpiar)
                    .addComponent(bEliminar)
                    .addComponent(bActualizar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoImporteActionPerformed

    private void campoDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDetallesActionPerformed

    private void campoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidoActionPerformed

    private void bAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAniadirActionPerformed
        //Tratamiento tr = new Tratamiento();
        agregar();
        campoApellido.setText("");
        campoNombre.setText("");
        campoDetalles.setText("");
        campoImporte.setText("");

    }//GEN-LAST:event_bAniadirActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
        

    }//GEN-LAST:event_bEliminarActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
        campoApellido.setText("");
        campoNombre.setText("");
        campoDetalles.setText("");
        campoImporte.setText("");
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
        campoApellido.setText("");
        campoNombre.setText("");
        campoDetalles.setText("");
        campoImporte.setText("");
    }//GEN-LAST:event_bActualizarActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
//        // TODO add your handling code here:
//        int fila = tblDatos.getSelectedRow();
//
//        String auxNombre = (String) dtm.getValueAt(fila, 1);
//        String auxApellido = (String) dtm.getValueAt(fila, 2);
//        String auxImporte = (String) dtm.getValueAt(fila, 3);
//        String auxDetalles = (String) dtm.getValueAt(fila, 4);

//        campoNombre.setText(auxNombre);
//        campoApellido.setText(auxApellido);
//        campoImporte.setText(auxImporte);
//        campoDetalles.setText(auxDetalles);
        boolean a = tblDatos.isEditing();
//        if (a == false) {
//            JOptionPane.showMessageDialog(null, "Tienes que actualizar para editar");
//        }
    }//GEN-LAST:event_tblDatosMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    private javax.swing.JTable tabla;
    private javax.swing.JScrollPane jScrollPane1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bAniadir;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoDetalles;
    private javax.swing.JTextField campoImporte;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaApellido;
    private javax.swing.JLabel etiquetaDetalles;
    private javax.swing.JLabel etiquetaImporte;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}