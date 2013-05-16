/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ssony
 */
public class Docente extends Persona{

    public Docente() {
        super();
    }

    public Docente(String nombre, String rut, String direccion, String comuna, String telefono, String Fnac, String email, String sexo,String pass, boolean esJefe, String cursoJefe) {
        super(nombre,rut,direccion,comuna,telefono,Fnac,email,sexo,pass);
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
