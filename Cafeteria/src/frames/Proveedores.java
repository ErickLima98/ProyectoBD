/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.ImageIcon;
import Seguridad.Conexion;
import Seguridad.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Proveedores extends javax.swing.JFrame {
    private static Usuario user;//variable global del usuario logeado
    /**
     * Creates new form Cliente
     */
    public Proveedores(Usuario user) {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        this.user=user;//Se asigna el usuaario que hizo login
        MostrarDatos("");  
        jButtonNuevo.setVisible(true);
        jButtonCancelar.setVisible(false);
        
        nombre.setEnabled(false);
        telefono.setEnabled(false);
        empresa.setEnabled(false);
        direccion.setEnabled(false);
      
        jButtonAgregar.setEnabled(false);
        jButtonAgregar.setVisible(false);
        jButtonModificar.setVisible(false);
    }
    
    private int Validar(){
        if(nombre.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(telefono.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(empresa.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(direccion.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else{
            return 0;
        }
    }
    
    private void MostrarDatos(String valor){
        try{Connection cn=Conexion.conectar();
            DefaultTableModel modelo=new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col==7;
                }
            };
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");
            modelo.addColumn("Empresa");
            modelo.addColumn("Numero");
            
            jTable1.setModel(modelo);
            String sql="";
            
            if(valor.equals("")){
                sql="select * from proveedores";
            }else{
                sql="SELECT * FROM proveedores WHERE (idProveedores='"+valor+"'  OR Nombre='"+valor+"' OR numero='"+valor+"')";
            }
            String []datos=new String [6];
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" +ex);
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
        jMenuModificar = new javax.swing.JMenuItem();
        jMenuInsertar = new javax.swing.JMenuItem();
        jButtonMenu = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        direccion = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        empresa = new javax.swing.JTextField();
        jLabelNit = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonModificar = new javax.swing.JButton();
        jButtonMostrar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        jMenuModificar.setText("jMenuItem1");
        jMenuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificarActionPerformed(evt);
            }
        });
        jPopOpciones.add(jMenuModificar);

        jMenuInsertar.setText("jMenuItem1");
        jMenuInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInsertarActionPerformed(evt);
            }
        });
        jPopOpciones.add(jMenuInsertar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMenu.setBackground(new java.awt.Color(255, 153, 102));
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Login2.png"))); // NOI18N
        jButtonMenu.setBorderPainted(false);
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 318, 40, 40));

        jButtonBuscar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search_1.png"))); // NOI18N
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 40, 30));

        jTextFieldBuscar.setBackground(new java.awt.Color(255, 153, 102));
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 180, -1));

        jButtonAgregar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/check2.png"))); // NOI18N
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 40, 40));

        jButtonCancelar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/error3.png"))); // NOI18N
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 40, 40));

        jButtonNuevo.setBackground(new java.awt.Color(255, 153, 102));
        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/AñadirNegro.png"))); // NOI18N
        jButtonNuevo.setBorderPainted(false);
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 40, 40));

        direccion.setBackground(new java.awt.Color(255, 153, 102));
        getContentPane().add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 60));

        jLabelDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDireccion.setText("Direccion :");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        empresa.setBackground(new java.awt.Color(255, 153, 102));
        empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresaActionPerformed(evt);
            }
        });
        getContentPane().add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        jLabelNit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelNit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNit.setText("Empresa :");
        getContentPane().add(jLabelNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        nombre.setBackground(new java.awt.Color(255, 153, 102));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, -1));

        jLabelTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTelefono.setText("Telefono :");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        telefono.setBackground(new java.awt.Color(255, 153, 102));
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        jLabelNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("Nombre :");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 520, 290));

        jButtonModificar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Lapiz.png"))); // NOI18N
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 40, 40));

        jButtonMostrar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, -1));

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
        menu otro = new menu();
        this.setVisible(false);
        otro.setVisible(true);
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        jButtonNuevo.setVisible(false);
        jButtonModificar.setVisible(false);
        
        jButtonCancelar.setVisible(true);
        jButtonAgregar.setVisible(true);
        jButtonAgregar.setEnabled(true);
        
        nombre.setEnabled(true);
        nombre.setText("");
        telefono.setEnabled(true);
        telefono.setText("");
        empresa.setEnabled(true);
        empresa.setText("");
        direccion.setEnabled(true);
        direccion.setText("");
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        try {
            Connection cn = Conexion.conectar();
            {
                if(Validar()==0)
                {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO proveedores(Nombre,Direccion,empresa, numero)VALUES(?,?,?,?)");
                    pst.setString(1,nombre.getText());
                    pst.setString(2,direccion.getText());
                    pst.setString(3,empresa.getText());
                    pst.setString(4,telefono.getText());
                    int a = pst.executeUpdate();
                    if(a>0)
                    {
                        JOptionPane.showMessageDialog(null,"Registro Exitoso");
                        MostrarDatos("");
                        nombre.setText(null);
                        direccion.setText(null);
                        empresa.setText(null);
                        telefono.setText(null);
                        jButtonCancelar.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Error al agregar");
                    }
                }//Fin del if
                else
                {
                    JOptionPane.showMessageDialog(null,"Llenar Todos Los Campos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }//Fin Conexion
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {Connection cn = Conexion.conectar();
            int fila = jTable1.getSelectedRow();
            String idC=" ";
            if(fila==-1){
                JOptionPane.showMessageDialog(null,"Seleccione una casilla","ERROR",JOptionPane.ERROR_MESSAGE);
            }else{
                idC=jTable1.getValueAt(fila,0).toString();
            }
            try {
                if (Validar()==0) {
                    PreparedStatement pst = cn.prepareStatement("UPDATE cliente set idCliente='"+idC+"',Nombre='"+nombre.getText()+"',Direccion='"+direccion.getText()+"',Telefono='"+telefono.getText()+"',Nit='"+empresa.getText()+"'WHERE idCliente='"+idC+"'");
                    pst.executeUpdate();
                    MostrarDatos("");
                    nombre.setText(null);
                    telefono.setText(null);
                    direccion.setText(null);
                    empresa.setText(null);
                    jButtonModificar.setVisible(false);
                    jButtonCancelar.setVisible(false);
                    jButtonNuevo.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Registro Modificado con Exito");
                } else {
                    JOptionPane.showMessageDialog(null,"Llenar Todos los Campos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR"+ e);
            }//try catch actualizadao
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ ex);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonNuevo.setVisible(true);
        jButtonCancelar.setVisible(false);
        
        jButtonAgregar.setVisible(false);
        jButtonModificar.setVisible(false);        
         
        nombre.setEnabled(false);
        telefono.setEnabled(false);
        empresa.setEnabled(false);
        direccion.setEnabled(false);

        nombre.setText("");
        telefono.setText("");
        empresa.setText("");
        direccion.setText("");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        MostrarDatos(jTextFieldBuscar.getText());
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jMenuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarActionPerformed
        jButtonAgregar.setVisible(false);
        jButtonNuevo.setVisible(false);

        nombre.setEnabled(true);
        telefono.setEnabled(true);
        empresa.setEnabled(true);
        direccion.setEnabled(true);
        
        int fila=jTable1.getSelectedRow();
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una Casilla", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            jButtonModificar.setVisible(true);
            jButtonCancelar.setVisible(true);
            //--------------------------------------------
            nombre.setText(jTable1.getValueAt(fila,1).toString());
            telefono.setText(jTable1.getValueAt(fila,2).toString());
            empresa.setText(jTable1.getValueAt(fila,3).toString());
            direccion.setText(jTable1.getValueAt(fila,4).toString());
        }
    }//GEN-LAST:event_jMenuModificarActionPerformed

    private void jMenuInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInsertarActionPerformed
        jButtonCancelar.setVisible(true);
        jButtonNuevo.setVisible(false);
        jButtonAgregar.setVisible(true);
        jButtonAgregar.setEnabled(true);
        jButtonModificar.setVisible(false);
         
        nombre.setEnabled(true);
        telefono.setEnabled(true);
        empresa.setEnabled(true);
        direccion.setEnabled(true);
        
        nombre.setText("");
        telefono.setText("");
        empresa.setText("");
        direccion.setText("");
    }//GEN-LAST:event_jMenuInsertarActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        MostrarDatos("");
        jButtonNuevo.setVisible(true);
        jButtonAgregar.setVisible(false);     
        jButtonModificar.setVisible(false);
        nombre.setText("");
        telefono.setText("");
        empresa.setText("");
        direccion.setText("");
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Proveedores(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField empresa;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNit;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JMenuItem jMenuInsertar;
    private javax.swing.JMenuItem jMenuModificar;
    private javax.swing.JPopupMenu jPopOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
