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
    }
    
  
    public Alumno(String nombre, String rut,String apellido, String direccion, int comuna, String telefono, Date Fnac, String email, int sexo,String pass) {
        super(nombre,apellido,rut,direccion,comuna, telefono,Fnac,email,sexo,pass);
    
    }
    
}
