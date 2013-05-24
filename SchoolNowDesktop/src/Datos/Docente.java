/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;

/**
 *
 * @author ssony
 */
public class Docente extends Persona{

    public Docente() {
        super();
        this.esJefe = false;
        this.cursoJefe = "";
    }

    public Docente(String nombre, String rut,String apellido, String direccion, int comuna, String telefono, Date Fnac, String email, int sexo,String pass, boolean esJefe, String cursoJefe) {
        super(nombre,apellido,rut,direccion,comuna,telefono,Fnac,email,sexo,pass);
        this.esJefe = esJefe;
        this.cursoJefe = cursoJefe;
    }
    
    private boolean esJefe;
    private String cursoJefe;

    public boolean isEsJefe() {
        return esJefe;
    }

    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }

    public String getCursoJefe() {
        return cursoJefe;
    }

    public void setCursoJefe(String cursoJefe) {
        this.cursoJefe = cursoJefe;
    }
    
}
