/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Seguridad.Conexion;
import Seguridad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author allec
 */
public class Compra extends javax.swing.JFrame {

    private static Usuario user;//variable global del usuario logeado

    /**
     * Creates new form Compra
     */
    public Compra() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        this.user = user;//Se asigna el usuaario que hizo login 

        LlenarcmProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCliente = new javax.swing.JLabel();
        jComboBoxProveedor = new javax.swing.JComboBox<>();
        jLabelProducto = new javax.swing.JLabel();
        jComboBoxProducto = new javax.swing.JComboBox<>();
        jLabelCantidad = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldCant = new javax.swing.JTextField();
        jButtonNuevaC = new javax.swing.JButton();
        jTextFieldCosto = new javax.swing.JTextField();
        jButtonTerminarAgregar = new javax.swing.JButton();
        jButtonTerminarAgregar1 = new javax.swing.JButton();
        jButtonTerminarC = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCliente.setText("Proveedor:");
        getContentPane().add(jLabelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        getContentPane().add(jComboBoxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, -1));

        jLabelProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Producto :");
        getContentPane().add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jComboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));

        jLabelCantidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad.setText("Cantidad:");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Costo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Login2.png"))); // NOI18N
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 30, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 480, 290));
        getContentPane().add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 320, 140, -1));

        jLabelTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total :");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, 20));
        getContentPane().add(jTextFieldCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 110, -1));

        jButtonNuevaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/NuevaCompraNegro.png"))); // NOI18N
        jButtonNuevaC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNuevaC.setBorderPainted(false);
        jButtonNuevaC.setContentAreaFilled(false);
        jButtonNuevaC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNuevaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jTextFieldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCostoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, -1));

        jButtonTerminarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/A+¦adirNegro.png"))); // NOI18N
        jButtonTerminarAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonTerminarAgregar.setBorderPainted(false);
        jButtonTerminarAgregar.setContentAreaFilled(false);
        jButtonTerminarAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTerminarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 40, 40));

        jButtonTerminarAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/error3.png"))); // NOI18N
        jButtonTerminarAgregar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonTerminarAgregar1.setBorderPainted(false);
        jButtonTerminarAgregar1.setContentAreaFilled(false);
        jButtonTerminarAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTerminarAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminarAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 40, 40));

        jButtonTerminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ComprarNegro.png"))); // NOI18N
        jButtonTerminarC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonTerminarC.setBorderPainted(false);
        jButtonTerminarC.setContentAreaFilled(false);
        jButtonTerminarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTerminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, 40));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Nuevo");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 40, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductoActionPerformed

    }//GEN-LAST:event_jComboBoxProductoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        menu otro = new menu();
        this.setVisible(false);
        otro.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextFieldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCostoActionPerformed

    }//GEN-LAST:event_jTextFieldCostoActionPerformed

    private void jButtonNuevaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNuevaCActionPerformed

    private void jButtonTerminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTerminarCActionPerformed

    private void jButtonTerminarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTerminarAgregarActionPerformed

    private void jButtonTerminarAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTerminarAgregar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNuevaC;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTerminarAgregar;
    private javax.swing.JButton jButtonTerminarAgregar1;
    private javax.swing.JButton jButtonTerminarC;
    private javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JComboBox<String> jComboBoxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCant;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    private void LlenarcmProducto() {
        try {
            Connection cn = Conexion.conectar();
            String sql = "";
            sql = "select *from inventario";
            String[] datos = new String[4];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                jComboBoxProducto.addItem(datos[0] + ".  " + datos[1]);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }
    
}
