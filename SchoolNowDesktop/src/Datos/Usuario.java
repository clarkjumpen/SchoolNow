/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Clark
 */
public class Usuario {

    private String user;
    private String pass;
    private int nivel;

    public Usuario() {
        this.user = "";
        this.pass = "";
        this.nivel = 0;
    }

    public Usuario(String user, String pass,int nivel) {
        this.user = user;
        this.pass = pass;
        this.nivel = nivel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
