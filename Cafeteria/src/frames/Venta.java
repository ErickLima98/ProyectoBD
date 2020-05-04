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
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        this.user = user;//Se asigna el usuaario que hizo login        

        LlenarcmbCliente();
        LlenarcmProducto();
        jButtonTerminarVenta.setEnabled(false);
        jButtonCancelarCompra.setEnabled(false);
        jButtonAgregar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jComboBoxCliente.setEnabled(false);
        jComboBoxProducto.setEnabled(false);
        jTextFieldCantidad.setText("");
        jTextFieldCantMaxima.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldCantidad.setEnabled(false);
        jTextFieldCantMaxima.setEnabled(false);
        jTextFieldPrecio.setEnabled(false);
        jTextFieldTotal.setEnabled(false);

        modelo = new DefaultTableModel();
        modelo.addColumn("Producto"); // se envian los titulos de la tabla
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");
        jTable1.setModel(modelo); // se  le envia el modelo
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
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
        jTextFieldTotal.setBounds(550, 310, 150, 22);

        jLabelTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("Total :");
        getContentPane().add(jLabelTotal);
        jLabelTotal.setBounds(510, 310, 40, 20);

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
        jButtonNuevaVenta.setToolTipText("<html>\n<head>\n\t<style>\n\t\t #contenido{ \n\t\tbackground: #111111;  /*Se le da un color de fondo*/\n\t\tcolor: white;\t\t  /*Color a la letra*/\n\t\t}\n\t</style>\n</head>\n<body>\n\t<div id=contenido>\n\t\t<h4>Nueva venta</h4>\n\t</div>\n</body>\n</html>");
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
        jButtonCancelarCompra.setToolTipText("<html>\n<head>\n\t<style>\n\t\t #contenido{ \n\t\tbackground: #111111;  /*Se le da un color de fondo*/\n\t\tcolor: white;\t\t  /*Color a la letra*/\n\t\t}\n\t</style>\n</head>\n<body>\n\t<div id=contenido>\n\t\t<h4>Cancelar venta</h4>\n\t</div>\n</body>\n</html>");
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
        jButtonTerminarVenta.setToolTipText("<html>\n<head>\n\t<style>\n\t\t #contenido{ \n\t\tbackground: #111111;  /*Se le da un color de fondo*/\n\t\tcolor: white;\t\t  /*Color a la letra*/\n\t\t}\n\t</style>\n</head>\n<body>\n\t<div id=contenido>\n\t\t<h4>Terminar venta</h4>\n\t</div>\n</body>\n</html>");
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
        jButtonEliminar.setToolTipText("<html>\n<head>\n\t<style>\n\t\t #contenido{ \n\t\tbackground: #111111;  /*Se le da un color de fondo*/\n\t\tcolor: white;\t\t  /*Color a la letra*/\n\t\t}\n\t</style>\n</head>\n<body>\n\t<div id=contenido>\n\t\t<h4>Cancelar</h4>\n\t</div>\n</body>\n</html>");
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar);
        jButtonEliminar.setBounds(170, 230, 40, 40);

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/AñadirNegro.png"))); // NOI18N
        jButtonAgregar.setToolTipText("<html>\n<head>\n\t<style>\n\t\t #contenido{ \n\t\tbackground: #111111;  /*Se le da un color de fondo*/\n\t\tcolor: white;\t\t  /*Color a la letra*/\n\t\t}\n\t</style>\n</head>\n<body>\n\t<div id=contenido>\n\t\t<h4>Agrega producto</h4>\n\t</div>\n</body>\n</html>");
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar);
        jButtonAgregar.setBounds(120, 230, 38, 40);
        getContentPane().add(jTextFieldCantMaxima);
        jTextFieldCantMaxima.setBounds(20, 180, 60, 22);

        jLabelCantidadMaxima.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidadMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidadMaxima.setText("Existencias:");
        getContentPane().add(jLabelCantidadMaxima);
        jLabelCantidadMaxima.setBounds(20, 160, 70, 17);
        getContentPane().add(jTextFieldCantidad);
        jTextFieldCantidad.setBounds(20, 240, 70, 22);

        jLabelCantidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCantidad.setText("Cantidad");
        getContentPane().add(jLabelCantidad);
        jLabelCantidad.setBounds(20, 220, 49, 17);

        jComboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProducto);
        jComboBoxProducto.setBounds(20, 130, 170, 22);

        jLabelProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Producto :");
        getContentPane().add(jLabelProducto);
        jLabelProducto.setBounds(20, 110, 59, 17);

        getContentPane().add(jComboBoxCliente);
        jComboBoxCliente.setBounds(20, 80, 170, 22);

        jLabelCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCliente.setText("Cliente :");
        getContentPane().add(jLabelCliente);
        jLabelCliente.setBounds(20, 60, 45, 17);

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Precio:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 160, 60, 17);
        getContentPane().add(jTextFieldPrecio);
        jTextFieldPrecio.setBounds(120, 180, 60, 22);

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 770, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fil, int col) {
            return col == 8;
        }
    };
    Object[] ObjectTabla = new Object[99999];

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

    private void insertarVenta() {
        try {
            Connection cn = Conexion.conectar();
            java.util.Date d = new java.util.Date();
            java.sql.Date date = new java.sql.Date(d.getTime());

            PreparedStatement pst = cn.prepareStatement("INSERT INTO venta(Fecha, Total, Usuario_idUsuario, Cliente_idCliente) VALUES(?,?,?,?)");
            pst.setDate(1, date);
            pst.setDouble(2, Double.parseDouble(jTextFieldTotal.getText()));
            pst.setInt(3, 1);
            pst.setInt(4, Integer.parseInt(jComboBoxCliente.getSelectedItem().toString().substring(0, 1)));
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Venta Generada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Generar Venta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
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

    private String ObtenerPrecio(String valor) {
        try {
            Connection cn = Conexion.conectar();

            String sql = "SELECT Precio_venta FROM inventario WHERE(idInventario ='" + valor + "')";
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

            String sql = "SELECT Existencias FROM inventario WHERE(idInventario ='" + valor + "')";
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

    private int Validar() {
        if (jTextFieldCantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        } else {
            return 0;
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
    }//GEN-LAST:event_jButtonNuevaVentaActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        double precio = Double.parseDouble(ObtenerPrecio(jComboBoxProducto.getSelectedItem().toString()));
        int cantMax = Integer.parseInt(ObtenerCantMax(jComboBoxProducto.getSelectedItem().toString()));

        if (Validar() == 0) {
            jComboBoxCliente.setEnabled(false);
            if (Integer.parseInt(jTextFieldCantidad.getText()) > cantMax) {
                JOptionPane.showMessageDialog(null, "No hay existencias suficientes para realizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (jTable1.getRowCount() - 1 == -1) {
                    ObjectTabla[0] = jComboBoxProducto.getSelectedItem().toString(); // Se agrega el medicamento
                    ObjectTabla[1] = jTextFieldCantidad.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Math.round((Double.parseDouble(jTextFieldCantidad.getText()) * precio) * 100) / 100d);// Se agrega el subtotal
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                } else {
                    ObjectTabla[0] = jComboBoxProducto.getSelectedItem().toString(); // Se agrega el medicamento
                    ObjectTabla[1] = jTextFieldCantidad.getText(); // Se agrega la cantidad
                    ObjectTabla[2] = (Math.round((Double.parseDouble(jTextFieldCantidad.getText()) * precio) * 100) / 100d); // Se obtiene el precio de venta y se multiplica por la cantidad
                    modelo.addRow(ObjectTabla); // se agrega toda la fila
                    jTable1.setModel(modelo); // se envia el modelo 
                }
                SumarSubtotal();
                jTextFieldCantidad.setText("");
            }
        }// FIn IF VALIDAR
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonTerminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarVentaActionPerformed
        int x = jTable1.getRowCount() - 1; // Se obtiene el numero de filas -1 porque empieza en 0
        if (x == -1) {
            JOptionPane.showMessageDialog(null, "La Venta Debe tener productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            insertarVenta();
            jButtonTerminarVenta.setEnabled(false);
            jButtonAgregar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            jComboBoxCliente.setEnabled(false);
            jComboBoxProducto.setEnabled(false);
            jTextFieldCantidad.setEnabled(false);
            jTextFieldCantMaxima.setEnabled(false);
            jTextFieldCantMaxima.setText("");
            jTextFieldCantidad.setText("");
            jTextFieldPrecio.setText("");
            jTextFieldTotal.setText("");
            while (x >= 0) {
                modelo.removeRow(x);
                x--;
            }
            JOptionPane.showMessageDialog(null, "Venta Terminada");
        }
    }//GEN-LAST:event_jButtonTerminarVentaActionPerformed

    private void jButtonCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCompraActionPerformed
        try {
            Connection cn = Conexion.conectar();
            Object[] botones = {"SI", " NO"};

            int x = jTable1.getRowCount() - 1; // Se obtiene el numero de filas -1 porque empieza en 0
            int x2 = x;
            int Ultim = obtenerUltimaVent(); // Se obtiene la venta que se genero          
            //int k = JOptionPane.showConfirmDialog(null, "Cancelar la ultima venta?", "Cancelar", JOptionPane.YES_NO_OPTION, HEIGHT);
            int k = JOptionPane.showOptionDialog(null, "Cancelar la ultima venta?", "CANCELAR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
            if (k == JOptionPane.YES_OPTION) {
                if (x == -1) {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM venta WHERE idVenta='" + Ultim + "'");// Se borra la compra
                    pst.executeUpdate(); // Manda la instruccion
                    JOptionPane.showMessageDialog(null, "Venta cancelada");
                } else {
                    while (x2 >= 0) {
                        String idProducto = jTable1.getValueAt(x2, 0).toString();
                        int cantProducto = Integer.parseInt(jTable1.getValueAt(x2, 1).toString());
                        EliminarVenta(idProducto, cantProducto);
                        x2--;
                    }
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM Venta WHERE idVenta='" + Ultim + "'");// Se borra la compra
                    pst.executeUpdate(); // Manda la instruccion                    
                    JOptionPane.showMessageDialog(null, "Venta Cancelada");
                }
                jButtonTerminarVenta.setEnabled(false);
                jButtonCancelarCompra.setEnabled(false);
                jButtonAgregar.setEnabled(false);
                jButtonEliminar.setEnabled(false);
                jComboBoxCliente.setEnabled(false);
                jComboBoxProducto.setEnabled(false);
                jTextFieldCantidad.setText("");
                jTextFieldCantMaxima.setText("");
                jTextFieldPrecio.setText("");
                jTextFieldCantidad.setEnabled(false);
                jTextFieldCantMaxima.setEnabled(false);
                jTextFieldPrecio.setEnabled(false);
                jTextFieldTotal.setEnabled(false);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Eror" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCancelarCompraActionPerformed

    private void jMenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEliminarActionPerformed

    }//GEN-LAST:event_jMenuEliminarActionPerformed

    private void jComboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductoActionPerformed
        int cantMax = Integer.parseInt(ObtenerCantMax(jComboBoxProducto.getSelectedItem().toString()));
        jTextFieldCantMaxima.setText(String.valueOf(cantMax));
        float precio = Float.parseFloat(ObtenerPrecio(jComboBoxProducto.getSelectedItem().toString()));
        jTextFieldPrecio.setText(String.valueOf(precio));
    }//GEN-LAST:event_jComboBoxProductoActionPerformed

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
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
