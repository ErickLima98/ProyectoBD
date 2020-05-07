/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;
import Seguridad.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Metodos_SQL {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;
    
    
    public int iddd(){
ResultSet rs= null;        
int i = 1;
         try {
             conexion = Conexion.conectar(); 
             String consulta = "SELECT MAX(idInventario) FROM inventario";
             sentencia_preparada = conexion.prepareStatement(consulta);
            rs = sentencia_preparada.executeQuery();
while(rs.next()){
    i = rs.getInt(1) + 1;
}
           conexion.close();

        } catch (HeadlessException | SQLException e) {

            System.out.println("Error2: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error3: " + e);
            }
        }
        
         
         return i;
    }
  
    public void guardar_datos(int idInventario, String Nombre, int Existencias, float Precio_venta) {

        try {
            conexion = Conexion.conectar();
            String consulta = "INSERT INTO inventario (idInventario,Nombre,Existencias,Precio_venta) VALUES (?,?,?,?)";
            sentencia_preparada = conexion.prepareStatement(consulta);
           sentencia_preparada.setInt(1, idInventario);
           sentencia_preparada.setString(2, Nombre);
           sentencia_preparada.setInt(3, Existencias);
           sentencia_preparada.setFloat(4, Precio_venta);
           
            int i = sentencia_preparada.executeUpdate();

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

            conexion.close();

        } catch (HeadlessException | SQLException e) {

            System.out.println("Error2: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error3: " + e);
            }
        }

    }
}
