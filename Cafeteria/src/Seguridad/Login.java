/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class Login {
    Connection conexion;
    
    public Login(){
        
    }
    
    public int login(String NombreUsuario, String clave){
        int resultado = 0;
        try {
            conexion = Conexion.conectar();     //Se conecta a la base de datos
            String consulta = "SELECT login (\""+NombreUsuario+"\",\""+clave+"\");"; //Se utiliza metodo almacenado en la BBDD para hacer el login
            PreparedStatement pre = conexion.prepareStatement(consulta); // se prepara la consulta y se envia el strign con la consuta
            ResultSet res = pre.executeQuery();     // se ejecuta la consulta
            if(res.next()){  //se verifica que haya obtenido un valor la consulta
                resultado = res.getInt(1); // se obtiene el resultado
            }
            conexion.close();   // se cierra la conexion
            return resultado;   //se retorna el resultado
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public Usuario getUsuario(String usuario){
       Usuario user = null;
        try {
            conexion = Conexion.conectar();     //Se conecta a la base de datos
            String consulta = "SELECT ac.Codigo, ac.Nombre, us.idUsuario FROM usuario us INNER JOIN acceso ac ON us.Acceso_idAcceso = ac.idAcceso WHERE us.Nombre = \""+usuario+"\";"; //Se utiliza metodo almacenado en la BBDD para hacer el login
            PreparedStatement pre = conexion.prepareStatement(consulta); // se prepara la consulta y se envia el strign con la consuta
            ResultSet res = pre.executeQuery();     // se ejecuta la consulta
            if(res.next()){  //se verifica que haya obtenido un valor la consulta
                user = new Usuario(res.getInt(1), res.getInt(3),usuario, res.getString(2));// se crea un objeto usuario con la info de la consulta a la BBDD
            }
            conexion.close();   // se cierra la conexion
            return user;   //se retorna el resultado
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user; 
    }
}
