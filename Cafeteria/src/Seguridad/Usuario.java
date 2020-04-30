/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

/**
 *
 * @author Erick
 */
public class Usuario {
    private int nivelAcceso, userId;    //almacena el codigo de nivel de acceso
    private String UserName, tipoUser;  //almacena el nombre y tipo de usuario
    
    public Usuario(int nivelAcceso, int userId, String Usarname, String tipoUser){
        this.nivelAcceso = nivelAcceso;
        this.userId = userId;
        this.UserName = Usarname;
        this.tipoUser = tipoUser;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return UserName;
    }

    public String getTipoUser() {
        return tipoUser;
    } 
}
