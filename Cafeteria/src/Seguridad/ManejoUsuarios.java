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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class ManejoUsuarios {
    Connection conexion;
    
    public ManejoUsuarios(){
        
    }
    
    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT us.idUsuario, us.Nombre, ac.Codigo, ac.Nombre FROM usuario us INNER JOIN acceso ac ON us.Acceso_idAcceso = ac.idAcceso;"; //consulta para la BBDD
            PreparedStatement pre = conexion.prepareStatement(consulta);
            ResultSet res = pre.executeQuery();
            while(res.next()){
                usuario.add(new Usuario(res.getInt(3), res.getInt(1), res.getString(2), res.getString(4)));
            }
            conexion.close();
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    public ArrayList<Acceso> getAcceso(){
        ArrayList<Acceso> acceso = new ArrayList<>();
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT idAcceso, Codigo, Nombre FROM acceso;"; //consulta para la BBDD
            PreparedStatement pre = conexion.prepareStatement(consulta);
            ResultSet res = pre.executeQuery();
            while(res.next()){
                acceso.add(new Acceso(res.getInt(1), res.getInt(2), res.getString(3)));
            }
            conexion.close();
            return acceso;
        } catch (SQLException ex) {
            Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acceso;
    }
    
    public boolean CrearUsuario(String username, String clave, int acceso){
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT crearUsuario (\""+username+"\",\""+clave+"\","+acceso+");"; //consulta para la BBDD
            PreparedStatement pre = conexion.prepareStatement(consulta);
            ResultSet res = pre.executeQuery();
            int creado = 0;
            if(res.next()){
                creado = res.getInt(1);
            }
            conexion.close();
            if(creado == 1){
                return true;
            }else return false;
        } catch (SQLException ex) {
            Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int ResestPass(String userName, String clave, int adminId){
        int resul = 0;
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT restaurarClave (\""+userName+"\",\""+clave+"\","+adminId+");"; //consulta para la BBDD
            PreparedStatement pre = conexion.prepareStatement(consulta);
            ResultSet res = pre.executeQuery();
            resul = 0;
            if(res.next()){
                resul = res.getInt(1);
            }
            conexion.close();
            return resul;
        } catch (SQLException ex) {
            Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resul;
    }
    
    public boolean changePass(Usuario user, String OldPass, String newPass){
        int resul = 0;
        
        Login log = new Login();
        resul = log.login(user.getUsername(), OldPass);
        
        if(resul!=1){
            return false;
        }else{
             try {
                conexion = Conexion.conectar();//se conecta a la base de datos
                String consulta = "UPDATE usuario SET contrasenia = md5(\""+newPass+"\") WHERE idUsuario = "+user.getUserId()+";";//consulta para la BBDD
                PreparedStatement pre = conexion.prepareStatement(consulta);//se prepara la consulta
                resul = pre.executeUpdate();//se ejecuta la consulta
                if(resul>0){
                    return true;
                }
                conexion.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean chageAccess(Usuario user, int acceso){
         try {
             conexion = Conexion.conectar();//se conecta a la base de datos
             String consulta = "UPDATE usuario SET Accesos_idAcceso ="+acceso+" WHERE idUsuario = "+user.getUserId()+";";//consulta para la BBDD
             PreparedStatement pre = conexion.prepareStatement(consulta);//se prepara la consulta
             int res = pre.executeUpdate();//se ejecuta la consulta
             if(res>0){
                 return true;
             }
             conexion.close();
             return false;
            } catch (SQLException ex) {
                Logger.getLogger(ManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
         return false;
    }
}
    
    

