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
public class Cliente extends javax.swing.JFrame {
    private static Usuario user;//variable global del usuario logeado
    /**
     * Creates new form Cliente
     */
    public Cliente(Usuario user) {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/cafe.png")).getImage());
        this.user=user;//Se asigna el usuaario que hizo login
        MostrarDatos("");  
        jButtonNuevo.setVisible(true);
        jButtonCancelar.setVisible(false);
        
        jTextFieldNombre.setEnabled(false);
        jTextFieldTelefono.setEnabled(false);
        jTextFieldNit.setEnabled(false);
        jTextFieldDireccion.setEnabled(false);
      
        jButtonAgregar.setEnabled(false);
        jButtonAgregar.setVisible(false);
        jButtonModificar.setVisible(false);
    }
    
    private int Validar(){
        if(jTextFieldNombre.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(jTextFieldTelefono.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(jTextFieldNit.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }else if(jTextFieldDireccion.getText().length()==0){
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
            modelo.addColumn("ID Cliente");
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            modelo.addColumn("Nit");
            
            jTable1.setModel(modelo);
            String sql="";
            
            if(valor.equals("")){
                sql="select * from Cliente";
            }else{
                sql="SELECT * FROM Cliente WHERE (idCliente='"+valor+"'  OR Nombre='"+valor+"' OR Telefono='"+valor+"')";
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
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldNit = new javax.swing.JTextField();
        jLabelNit = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
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

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Login2.png"))); // NOI18N
        jButtonMenu.setBorderPainted(false);
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 40, -1));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search_1.png"))); // NOI18N
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setContentAreaFilled(false);
        jButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 40, 30));
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 180, -1));

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/check2.png"))); // NOI18N
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 40, 40));

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/error3.png"))); // NOI18N
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 40, 40));

        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/AñadirNegro.png"))); // NOI18N
        jButtonNuevo.setBorderPainted(false);
        jButtonNuevo.setContentAreaFilled(false);
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 40, 40));
        getContentPane().add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 60));

        jLabelDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDireccion.setText("Direccion :");
        getContentPane().add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(jTextFieldNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        jLabelNit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelNit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNit.setText("Nit :");
        getContentPane().add(jLabelNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, -1));

        jLabelTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTelefono.setText("Telefono :");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

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

        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Lapiz.png"))); // NOI18N
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 40, 40));

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

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

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
        
        jTextFieldNombre.setEnabled(true);
        jTextFieldNombre.setText("");
        jTextFieldTelefono.setEnabled(true);
        jTextFieldTelefono.setText("");
        jTextFieldNit.setEnabled(true);
        jTextFieldNit.setText("");
        jTextFieldDireccion.setEnabled(true);
        jTextFieldDireccion.setText("");
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        try {Connection cn=Conexion.conectar();
        {
            if(Validar()==0){
                PreparedStatement pst = cn.prepareStatement("INSERT INTO cliente(Nombre,Telefono,Nit,Direccion)Values(?,?,?,?)");
                pst.setString(1,jTextFieldNombre.getText());
                pst.setString(2,jTextFieldTelefono.getText());
                pst.setString(3,jTextFieldNit.getText());
                pst.setString(4,jTextFieldDireccion.getText());
                
                int a =pst.executeUpdate();
                if(a>0){
                    JOptionPane.showMessageDialog(null,"Registro Exitos");
                    MostrarDatos("");
                    jTextFieldNombre.setText(null);
                    jTextFieldTelefono.setText(null);
                    jTextFieldDireccion.setText(null);
                    jTextFieldNit.setText(null);
                    jTextFieldTelefono.setText(null);
                }else{
                    JOptionPane.showMessageDialog(null,"Error al Agragar");
                }//fin del segundo if
            }else{
                JOptionPane.showMessageDialog(null, "Llenar Todos los Campos","Error",JOptionPane.ERROR_MESSAGE);
            }//fin del primer if
        }//Fin del tray conexion 
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
                    PreparedStatement pst = cn.prepareStatement("UPDATE cliente set idCliente='"+idC+"',Nombre='"+jTextFieldNombre.getText()+"',Direccion='"+jTextFieldDireccion.getText()+"',Telefono='"+jTextFieldTelefono.getText()+"',Nit='"+jTextFieldNit.getText()+"'WHERE idCliente='"+idC+"'");
                    pst.executeUpdate();
                    MostrarDatos("");
                    jTextFieldNombre.setText(null);
                    jTextFieldTelefono.setText(null);
                    jTextFieldDireccion.setText(null);
                    jTextFieldNit.setText(null);
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
         
        jTextFieldNombre.setEnabled(false);
        jTextFieldTelefono.setEnabled(false);
        jTextFieldNit.setEnabled(false);
        jTextFieldDireccion.setEnabled(false);

        jTextFieldNombre.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldNit.setText("");
        jTextFieldDireccion.setText("");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        MostrarDatos(jTextFieldBuscar.getText());
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jMenuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarActionPerformed
        jButtonAgregar.setVisible(false);
        jButtonNuevo.setVisible(false);

        jTextFieldNombre.setEnabled(true);
        jTextFieldTelefono.setEnabled(true);
        jTextFieldNit.setEnabled(true);
        jTextFieldDireccion.setEnabled(true);
        
        int fila=jTable1.getSelectedRow();
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione una Casilla", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            jButtonModificar.setVisible(true);
            jButtonCancelar.setVisible(true);
            //--------------------------------------------
            jTextFieldNombre.setText(jTable1.getValueAt(fila,1).toString());
            jTextFieldTelefono.setText(jTable1.getValueAt(fila,2).toString());
            jTextFieldNit.setText(jTable1.getValueAt(fila,3).toString());
            jTextFieldDireccion.setText(jTable1.getValueAt(fila,4).toString());
        }
    }//GEN-LAST:event_jMenuModificarActionPerformed

    private void jMenuInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInsertarActionPerformed
        jButtonCancelar.setVisible(true);
        jButtonNuevo.setVisible(false);
        jButtonAgregar.setVisible(true);
        jButtonAgregar.setEnabled(true);
        jButtonModificar.setVisible(false);
         
        jTextFieldNombre.setEnabled(true);
        jTextFieldTelefono.setEnabled(true);
        jTextFieldNit.setEnabled(true);
        jTextFieldDireccion.setEnabled(true);
        
        jTextFieldNombre.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldNit.setText("");
        jTextFieldDireccion.setText("");
    }//GEN-LAST:event_jMenuInsertarActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        MostrarDatos("");
        jButtonNuevo.setVisible(true);
        jButtonAgregar.setVisible(false);     
        jButtonModificar.setVisible(false);
        jTextFieldNombre.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldNit.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButtonMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNit;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
