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
public class Alumno extends Persona{

    public Alumno() {
        super();
        this.estado=0;
    }
    private int estado;
  
    public Alumno(String nombre, String rut,String apellido, String direccion, int comuna, String telefono, Date Fnac, String email, int sexo,String pass,int estado) {
        super(nombre,apellido,rut,direccion,comuna, telefono,Fnac,email,sexo,pass);
    
        this.estado=estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
