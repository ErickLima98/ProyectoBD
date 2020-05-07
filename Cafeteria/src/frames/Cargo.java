/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Seguridad.Conexion;
import Seguridad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author allec
 */
public class Cargo extends javax.swing.JFrame {

    private static Usuario user;//variable global del usuario logeado

    /**
     * Creates new form Compra
     */
    public Cargo() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        this.user = user;//Se asigna el usuaario que hizo login 
        jTextFieldCant.setEnabled(false);
        jTextFieldNombre.setEnabled(false);
        jTextFieldCosto.setEnabled(false);
        jTextFieldTotal.setEnabled(false);
        jTextFieldPrecio.setEnabled(false);
        jButtonNuevo.setEnabled(false);
        jButtonAgregar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonTerminarC.setEnabled(false);
        jComboBoxProducto.setEnabled(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Producto"); // se envian los titulos de la tabla
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");
        jTable1.setModel(modelo); // se  le envia el modelo

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
        jButtonAgregar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonTerminarC = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jLabelCantidad1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelCantidad2 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jButtonRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Producto :");
        getContentPane().add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jComboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, -1));

        jLabelCantidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad.setText("Nombre:");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Costo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButtonSalir.setBackground(new java.awt.Color(255, 153, 102));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Login2.png"))); // NOI18N
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 40, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 480, 290));
        getContentPane().add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 150, -1));

        jLabelTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total :");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, 20));
        getContentPane().add(jTextFieldCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, -1));

        jButtonNuevaC.setBackground(new java.awt.Color(255, 153, 102));
        jButtonNuevaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/NuevaCompraNegro.png"))); // NOI18N
        jButtonNuevaC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNuevaC.setBorderPainted(false);
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
        getContentPane().add(jTextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, -1));

        jButtonAgregar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/A+¦adirNegro.png"))); // NOI18N
        jButtonAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 40, 40));

        jButtonCancelar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/error3.png"))); // NOI18N
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 40, 40));

        jButtonTerminarC.setBackground(new java.awt.Color(255, 153, 102));
        jButtonTerminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ComprarNegro.png"))); // NOI18N
        jButtonTerminarC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonTerminarC.setBorderPainted(false);
        jButtonTerminarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTerminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, 40));

        jButtonNuevo.setBackground(new java.awt.Color(255, 153, 102));
        jButtonNuevo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNuevo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNuevo.setDefaultCapable(false);
        jButtonNuevo.setFocusPainted(false);
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 20));

        jLabelCantidad1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad1.setText("Cantidad:");
        getContentPane().add(jLabelCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, -1));

        jLabelCantidad2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad2.setText("Precio:");
        getContentPane().add(jLabelCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));
        getContentPane().add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 80, -1));

        jButtonRefrescar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/refrescar.png"))); // NOI18N
        jButtonRefrescar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jButtonRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 360));

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
        jTextFieldCant.setEnabled(true);
        jTextFieldCosto.setEnabled(true);
        jButtonNuevo.setEnabled(true);
        jButtonAgregar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonTerminarC.setEnabled(true);
        jComboBoxProducto.setEnabled(true);
    }//GEN-LAST:event_jButtonNuevaCActionPerformed

    private void jButtonTerminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarCActionPerformed
        int x = jTable1.getRowCount() - 1; // Se obtiene el numero de filas -1 porque empieza en 0
        if (x == -1) {
            JOptionPane.showMessageDialog(null, "El cargo debe tener productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            insertarCargo();
            jButtonNuevo.setEnabled(false);
            jButtonAgregar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonTerminarC.setEnabled(false);
            jComboBoxProducto.setEnabled(false);
            jTextFieldCant.setEnabled(false);
            jTextFieldCosto.setEnabled(false);
            jTextFieldPrecio.setEnabled(false);
            jTextFieldNombre.setEnabled(false);
            jTextFieldCant.setText("");
            jTextFieldCosto.setText("");
            jTextFieldNombre.setText("");
            jTextFieldPrecio.setText("");
            jTextFieldTotal.setText("");
            while (x >= 0) {
                modelo.removeRow(x);
                x--;
            }
            JOptionPane.showMessageDialog(null, "Cargo Terminado");
        }
    }//GEN-LAST:event_jButtonTerminarCActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        double costo = Double.parseDouble(jTextFieldCosto.getText().toString());
        boolean acti = jTextFieldNombre.isEnabled();

        if (Validar() == 0) {
            if (acti == true) {
                ObjectTabla[0] = jTextFieldNombre.getText(); // Se agrega el produc
                ObjectTabla[1] = jTextFieldCant.getText(); // Se agrega la cantidad
                ObjectTabla[2] = (Math.round((Double.parseDouble(jTextFieldCant.getText()) * costo) * 100) / 100d);// Se agrega el subtotal
                modelo.addRow(ObjectTabla); // se agrega toda la fila
                jTable1.setModel(modelo); // se envia el modelo 
                insertarMenu();
                jTextFieldNombre.setEnabled(false);
                jTextFieldPrecio.setEnabled(false);
                jTextFieldNombre.setText("");
                jTextFieldPrecio.setText("");
            } else {
                if (jTable1.getRowCount() - 1 == -1) {
                    ObjectTabla[0] = jComboBoxProducto.getSelectedItem().toString(); // Se agrega el produc
                    ObjectTabla[1] = jTextFieldCant.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Math.round((Double.parseDouble(jTextFieldCant.getText()) * costo) * 100) / 100d);// Se agrega el subtotal
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                    actualizarInventario(0);
                } else {
                    ObjectTabla[0] = jComboBoxProducto.getSelectedItem().toString(); // Se agrega el medicamento
                    ObjectTabla[1] = jTextFieldCant.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Math.round((Double.parseDouble(jTextFieldCant.getText()) * costo) * 100) / 100d);
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                    actualizarInventario(0);
                }
            }
            SumarSubtotal();
            jTextFieldCant.setText("");
            jTextFieldCosto.setText("");
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        jTextFieldNombre.setEnabled(true);
        jTextFieldPrecio.setEnabled(true);
    }//GEN-LAST:event_jButtonNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNuevaC;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonRefrescar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTerminarC;
    private javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCantidad1;
    private javax.swing.JLabel jLabelCantidad2;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCant;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fil, int col) {
            return col == 8;
        }
    };
    Object[] ObjectTabla = new Object[99999];

    private void LlenarcmProducto() {
        try {
            Connection cn = Conexion.conectar();
            String sql = "";
            sql = "select *from menu";
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

    private void insertarCargo() {
        try {
            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement("INSERT INTO cargar(Total) VALUES(?)");
            pst.setDouble(1, Double.parseDouble(jTextFieldTotal.getText()));
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Cargo Generado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Generar Cargo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    private String ObtenerPrecio(String valor) {
        try {
            Connection cn = Conexion.conectar();

            String sql = "SELECT Precio FROM menu WHERE(idProducto ='" + valor + "')";
            String datos = "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString(1);
            }
            return datos;
        }// Fin TRY 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
            return "";
        }
    }

    private int Validar() {
        if (jTextFieldCant.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        } else {
            return 0;
        }
    }

    private void actualizarInventario(int estado) {
        try {
            Connection cn = Conexion.conectar();

            if (estado == 0) {
                int idP = Integer.parseInt(jComboBoxProducto.getSelectedItem().toString().substring(0, 1));
                int cantP = Integer.parseInt(jTextFieldCant.getText());

                PreparedStatement pst = cn.prepareStatement("UPDATE Menu SET "
                        + "cantidad = cantidad +'" + cantP + "' "
                        + "WHERE "
                        + "idProducto ='" + idP + "'");

                int a = pst.executeUpdate();
                if (a > 0) {
                    System.out.println("Acutlizado");
                } else {
                    System.out.println("Error al acutlizar");
                }
            } else if (estado == 1) {//si el esado es 1 se debe de decontar lo que se habia agregado en la venta parcial    
                int fila = jTable1.getSelectedRow();
                int idP = Integer.parseInt(jTable1.getValueAt(fila, 0).toString().substring(0, 1));
                int cantP = Integer.parseInt(jTable1.getValueAt(fila, 1).toString());

                PreparedStatement pst = cn.prepareStatement("UPDATE menu SET "
                        + "cantidad = cantidad -'" + cantP + "' "
                        + "WHERE "
                        + "idProducto ='" + idP + "'");

                int a = pst.executeUpdate();
                if (a > 0) {
                    System.out.println("Acutlizado");
                } else {
                    System.out.println("Error al acutlizar");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    private double SumarSubtotal() {
        int filas = jTable1.getRowCount() - 1;
        double Total = 0;

        while (filas >= 0) {
            double sub = Double.parseDouble(jTable1.getValueAt(filas, 2).toString());
            Total = Total + sub;
            filas--;
        }
        Total = Math.round(Total * 100) / 100d;
        jTextFieldTotal.setText(String.valueOf(Total));
        return Total;
    }

    private void insertarMenu() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO menu(Nombre,Cantidad,Precio)VALUES(?,?,?)");
            pst.setString(1, jTextFieldNombre.getText());
            pst.setString(2, jTextFieldCant.getText());
            pst.setDouble(3, Double.parseDouble(jTextFieldPrecio.getText()));
            int a = pst.executeUpdate();
            if (a > 0) {
                System.out.println("Registro exitorso");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
        }
    }
}