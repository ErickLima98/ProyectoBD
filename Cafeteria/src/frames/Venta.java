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

/**
 *
 * @author USUARIO
 */
public class Venta extends javax.swing.JFrame {

    private static Usuario user;//variable global del usuario logeado

    /**
     * Creates new form Venta
     */
    public Venta() {
        this.user = user;//Se asigna el usuaario que hizo login        
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        LlenarcmbCliente();
        LlenarcmProducto();
//        jTextFieldCantidad.setEnabled(false);
//        jButtonAgregar.setVisible(false);
//        jButtonEliminar.setVisible(false);
//        jButtonTerminarVenta.setVisible(false);
//        jButtonCancelarCompra.setVisible(false);
//        jComboBoxProducto.setEnabled(false);

        jButtonTerminarVenta.setEnabled(false);
        jButtonCancelarCompra.setEnabled(false);
        jButtonAgregar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jComboBoxCliente.setEnabled(false);
        jComboBoxProducto.setEnabled(false);
        jTextFieldCantidad.setEnabled(false);
        jTextFieldCantMaxima.setEnabled(false);
    }

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fil, int col) {
            return col == 8;
        }
    };
    Object[] ObjectTabla = new Object[99999];

    private void mostrardatos(String valor) {
        try {
            Connection cn = Conexion.conectar();
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col == 7;
                }
            };
            int UltimVe = obtenerUltimaVent();
            jTable1.setModel(modelo);
            String sql = "";
            if (valor.equals("")) {
                //sql=" select med.Nombre, ped.Cantidad_Medi, (ped.Cantidad_Medi * med.PrecioInt) as subtotal from pedido ped inner join lote lot on ped.Lote_idLotes = lot.idLotes inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento  where (ped.Venta_idVenta = '"+UltimVe+"' ) ";
            }
            String[] datos = new String[6];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    private int Validar() {
        if (jTextFieldCantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        } else {
            return 0;
        }
    }

    private void EliminarVenta(String idMedi, int Cant) {
        try {
            int idventa = obtenerUltimaVent();
            idMedi = idMedi.substring(0, 1);
            Connection cn = Conexion.conectar();
            String sql = "";
            //sql = " select lot.idLotes,  ped.Cantidad_Medi, med.idMedicamento, ped.idPedido from pedido ped inner join lote lot on ped.Lote_idLotes =  lot.idLotes inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento where (ped.Cantidad_Medi ="+Cant+" and med.idMedicamento ="+idMedi+" and ped.Venta_idVenta ="+idventa+") ";
            String[] datos = new String[6];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
            }
            /*PreparedStatement pst=cn.prepareStatement("UPDATE  Lote  set lote.Existencia = (Lote.Existencia + '"+datos[1]+"' ) where (lote.idLotes = '"+datos[0]+"' ) ");
            pst.executeUpdate();     
            PreparedStatement pst2=cn.prepareStatement("UPDATE  Pedido  set Pedido.Cantidad_Medi = '0'  where (pedido.idPedido = '"+datos[3]+"' ) ");
            pst2.executeUpdate();*/
        } // Fin try
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        } // Fin Catch   
    }

    private void insertarVenta() {
        try {
            Connection cn = Conexion.conectar();
            java.util.Date d = new java.util.Date();
            java.sql.Date date = new java.sql.Date(d.getTime());
            PreparedStatement pst = cn.prepareStatement("INSERT INTO Venta(Usuario_idUsuario,Cliente_idCliente,Fecha,Total) VALUES(?,?,?,?)");
            pst.setInt(1, 2);
            pst.setInt(2, Integer.parseInt(jComboBoxCliente.getSelectedItem().toString().substring(0, 1)));
            pst.setDate(3, date);
            pst.setInt(4, 1);
            pst.setBoolean(5, false);
            int a = pst.executeUpdate();
            if (a > 0) {
                // JOptionPane.showMessageDialog(null,"Venta Generada");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al Generar Venta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    private int obtenerUltimaVent() {
        try {
            Connection cn = Conexion.conectar();
            String sql = "Select * from venta";
            String idVent = "";
            int iD;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idVent = rs.getString(1);
            }
            iD = Integer.parseInt(idVent);
            return iD;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
            return 0;
        }
    }

    private void actualizarventa() {
        try {
            Connection cn = Conexion.conectar();
            int idCliente = 0;
            idCliente = Integer.parseInt(jComboBoxCliente.getSelectedItem().toString().substring(0, 1));
            double tot = SumarSubtotal();
            int idVent = obtenerUltimaVent();//---------------------------------------------------------------------------------ACAAAA---CORREGIR EL USUARIO
            PreparedStatement pst = cn.prepareStatement("UPDATE Venta SET Usuario_idUsuario='" + user.getUserId() + "',Cliente_idCliente='" + idCliente + "',Total='" + tot + "',WHERE idVenta='" + idVent + "' ");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }

    private String ObtenerPrecio(String valor, int preci) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "";
            if (preci == 1) {
                sql = "select inventario.Precio_venta from inventario WHERE (idInventario='" + valor + "')";
            }
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

    private String ObtenerCantMax(String valor) {
        try {
            Connection cn = Conexion.conectar();
            String sql = "select inv.Existencias from inventario inv WHERE(id.Inventario='" + valor + "')";
            String CantMax = "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CantMax = rs.getString(1);
            }
            return CantMax;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
            return "";
        }
    }

    private double SumarSubtotal() {
        int filas = jTable1.getRowCount() - 1;
        double Total = 0;
        double Tot = 0;
        while (filas >= 0) {
            double sub = Double.parseDouble(jTable1.getValueAt(filas, 2).toString());
            Total = Total + sub;
            filas--;
        }
        jTextFieldTotal.setText(String.valueOf(Total));
        return Total;
    }

    private void LlenarcmbCliente() {
        try {
            Connection cn = Conexion.conectar();
            String sql = "";
            sql = "select *from cliente ";
            String[] datos = new String[4];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                jComboBoxCliente.addItem(datos[0] + ".  " + datos[1]);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopOpciones = new javax.swing.JPopupMenu();
        jMenuEliminar = new javax.swing.JMenuItem();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNuevaVenta = new javax.swing.JButton();
        jButtonCancelarCompra = new javax.swing.JButton();
        jButtonTerminarVenta = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jTextFieldCantMaxima = new javax.swing.JTextField();
        jLabelCantidadMaxima = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabelCantidad = new javax.swing.JLabel();
        jComboBoxProducto = new javax.swing.JComboBox<>();
        jLabelProducto = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabelCliente = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        jMenuEliminar.setText("jMenuItem1");
        jMenuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEliminarActionPerformed(evt);
            }
        });
        jPopOpciones.add(jMenuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venta");
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(770, 370));
        setName(""); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(jTextFieldTotal);
        jTextFieldTotal.setBounds(640, 310, 60, 22);

        jLabelTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total :");
        getContentPane().add(jLabelTotal);
        jLabelTotal.setBounds(590, 310, 40, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 20, 480, 280);

        jButtonNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/NuevaCompraNegro.png"))); // NOI18N
        jButtonNuevaVenta.setBorderPainted(false);
        jButtonNuevaVenta.setContentAreaFilled(false);
        jButtonNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevaVenta);
        jButtonNuevaVenta.setBounds(10, 10, 38, 40);

        jButtonCancelarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/CancelarCarritoNegro.png"))); // NOI18N
        jButtonCancelarCompra.setBorderPainted(false);
        jButtonCancelarCompra.setContentAreaFilled(false);
        jButtonCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCompraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelarCompra);
        jButtonCancelarCompra.setBounds(130, 10, 38, 38);

        jButtonTerminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ComprarNegro.png"))); // NOI18N
        jButtonTerminarVenta.setBorderPainted(false);
        jButtonTerminarVenta.setContentAreaFilled(false);
        jButtonTerminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminarVenta);
        jButtonTerminarVenta.setBounds(70, 10, 40, 38);

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/error3.png"))); // NOI18N
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar);
        jButtonEliminar.setBounds(130, 230, 40, 40);

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/AñadirNegro.png"))); // NOI18N
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar);
        jButtonAgregar.setBounds(20, 230, 38, 40);
        getContentPane().add(jTextFieldCantMaxima);
        jTextFieldCantMaxima.setBounds(90, 200, 100, 22);

        jLabelCantidadMaxima.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidadMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidadMaxima.setText("Cantidad Maxima");
        getContentPane().add(jLabelCantidadMaxima);
        jLabelCantidadMaxima.setBounds(90, 180, 98, 17);
        getContentPane().add(jTextFieldCantidad);
        jTextFieldCantidad.setBounds(20, 200, 50, 22);

        jLabelCantidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad.setText("Cantidad");
        getContentPane().add(jLabelCantidad);
        jLabelCantidad.setBounds(20, 180, 49, 17);

        getContentPane().add(jComboBoxProducto);
        jComboBoxProducto.setBounds(20, 150, 170, 22);

        jLabelProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Producto :");
        getContentPane().add(jLabelProducto);
        jLabelProducto.setBounds(20, 130, 59, 17);

        getContentPane().add(jComboBoxCliente);
        jComboBoxCliente.setBounds(20, 100, 170, 22);

        jLabelCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCliente.setText("Cliente :");
        getContentPane().add(jLabelCliente);
        jLabelCliente.setBounds(20, 80, 45, 17);

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Login2.png"))); // NOI18N
        jButtonMenu.setBorderPainted(false);
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu);
        jButtonMenu.setBounds(720, 300, 40, 40);

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 770, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        menu otro = new menu();
        this.setVisible(false);
        otro.setVisible(true);
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        String idCompra = "";
        int cantCompra = 0;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            idCompra = jTable1.getValueAt(fila, 0).toString();
            cantCompra = Integer.parseInt(jTable1.getValueAt(fila, 1).toString());
            int k = JOptionPane.showConfirmDialog(null, "Eliminar producto?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (k == JOptionPane.YES_OPTION) {
                EliminarVenta(idCompra, cantCompra);
                int x = jTable1.getRowCount() - 1;
                modelo.removeRow(fila);
                SumarSubtotal();
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaVentaActionPerformed
        jButtonTerminarVenta.setEnabled(true);
        jButtonCancelarCompra.setEnabled(true);
        jButtonAgregar.setEnabled(true);
        jButtonEliminar.setEnabled(true);
        jComboBoxCliente.setEnabled(true);
        jComboBoxProducto.setEnabled(true);
        jTextFieldCantidad.setEnabled(true);
        jTextFieldCantMaxima.setEnabled(true);
        //insertarVenta();      
    }//GEN-LAST:event_jButtonNuevaVentaActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        double precio = 0;

        int cantMax = Integer.parseInt(ObtenerCantMax(jComboBoxProducto.getSelectedItem().toString()));
        jTextFieldCantMaxima.setText(String.valueOf(cantMax));
        if (Validar() == 0) {
            jComboBoxCliente.setEnabled(false);
            if (Integer.parseInt(jTextFieldCantidad.getText()) > cantMax) {
                JOptionPane.showMessageDialog(null, "No hay existencias suficientes para esta venta ", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (jTable1.getRowCount() - 1 == -1) {
                    modelo = new DefaultTableModel();
                    modelo.addColumn("Producto"); // se envian los titulos de la tabla
                    modelo.addColumn("Cantidad");
                    modelo.addColumn("Subtotal");
                    jTable1.setModel(modelo); // se  le envia el modelo
                    ObjectTabla[0] = jComboBoxCliente.getSelectedItem().toString(); // Se agrega el medicamento
                    ObjectTabla[1] = jTextFieldCantidad.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Double.parseDouble(jTextFieldCantidad.getText()) * precio);// Se agrega el subtotal
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                } else {
                    ObjectTabla[0] = jComboBoxProducto.getSelectedItem().toString(); // Se agrega el medicamento
                    ObjectTabla[1] = jTextFieldCantidad.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Integer.parseInt(jTextFieldCantidad.getText()) * precio); // Se obtiene el precio de venta y se multiplica por la cantidad
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                }
                SumarSubtotal();
                jTextFieldCantidad.setText("");
                cantMax = Integer.parseInt(ObtenerCantMax(jComboBoxProducto.getSelectedItem().toString()));
                jTextFieldCantidad.setText(String.valueOf(cantMax));
            }
        }// FIn IF VALIDAR
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonTerminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarVentaActionPerformed
        //actualizarventa();
        int x = jTable1.getRowCount() - 1; // Se obtiene el numero de filas -1 porque empieza en 0
        jButtonTerminarVenta.setEnabled(false);
            jButtonCancelarCompra.setEnabled(false);
            jButtonAgregar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            jComboBoxCliente.setEnabled(false);
            jComboBoxProducto.setEnabled(false);
            jTextFieldCantidad.setEnabled(false);
            jTextFieldCantMaxima.setEnabled(false);
        if (x == -1) {
            JOptionPane.showMessageDialog(null, "La Venta Debe tener productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
//            jTextFieldCantidad.setEnabled(false);
//            jTable1.setEnabled(false);
//            jComboBoxProducto.setEnabled(false);
//            jButtonAgregar.setVisible(false);
//            jButtonAgregar.setEnabled(false);
//            jButtonCancelarCompra.setVisible(false);
//            jButtonEliminar.setVisible(false);
//            jButtonTerminarVenta.setVisible(false);
//            jTable1.setEnabled(false);
            
            System.out.println("1 " + x);
            while (x >= 0) {
                modelo.removeRow(x);
                x--;
            }
            jTextFieldTotal.setText(null);
            JOptionPane.showMessageDialog(null, "Venta Terminada");
            jButtonNuevaVenta.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonTerminarVentaActionPerformed

    private void jButtonCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCompraActionPerformed
        try {
            Connection cn = Conexion.conectar();

            int x = jTable1.getRowCount() - 1; // Se obtiene el numero de filas -1 porque empieza en 0
            int x2 = x;
            int Ultim = obtenerUltimaVent(); // Se obtiene la venta que se genero

            int k = JOptionPane.showConfirmDialog(null, "Cancelar Venta?", "Cancelar", JOptionPane.YES_NO_OPTION);
            if (k == JOptionPane.YES_OPTION) {
                if (x == -1) {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM venta WHERE idVenta='" + Ultim + "'");// Se borra la compra
                    pst.executeUpdate(); // Manda la instruccion
                    JOptionPane.showMessageDialog(null, "Venta Cancelada");
                } else {
                    while (x2 >= 0) {
                        String idProducto = jTable1.getValueAt(x2, 0).toString();
                        int cantProducto = Integer.parseInt(jTable1.getValueAt(x2, 1).toString());
                        EliminarVenta(idProducto, cantProducto);
                        x2--;
                    }
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM Venta WHERE idVenta='" + Ultim + "'");// Se borra la compra
                    pst.executeUpdate(); // Manda la instruccion
                    jTextFieldTotal.setText(null);
                    JOptionPane.showMessageDialog(null, "Venta Cancelada");
                }
                jTable1.setEnabled(false);
                jComboBoxProducto.setEnabled(false);

                jTextFieldCantidad.setEnabled(false);
                jTextFieldCantidad.setText(null);

                jButtonAgregar.setVisible(false);
                jButtonTerminarVenta.setVisible(false);

                jButtonCancelarCompra.setVisible(false);
                jButtonEliminar.setVisible(false);

                jButtonNuevaVenta.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Eror" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCancelarCompraActionPerformed

    private void jMenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        String idProducto = "";
        int cantProducto = 0;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            idProducto = jTable1.getValueAt(fila, 0).toString();
            cantProducto = Integer.parseInt(jTable1.getValueAt(fila, 1).toString());
            int k = JOptionPane.showConfirmDialog(null, "Eliminar producto?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (k == JOptionPane.YES_OPTION) {
                EliminarVenta(idProducto, cantProducto);
                int x = jTable1.getRowCount() - 1;
                modelo.removeRow(fila);
                SumarSubtotal();
            }
        }
    }//GEN-LAST:event_jMenuEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelarCompra;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonNuevaVenta;
    private javax.swing.JButton jButtonTerminarVenta;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCantidadMaxima;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenuItem jMenuEliminar;
    private javax.swing.JPopupMenu jPopOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCantMaxima;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
