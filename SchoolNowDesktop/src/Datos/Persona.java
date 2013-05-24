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
public class Persona {

    private String nombre;
    private String apellido;
    private String rut;
    private String direccion;
    private int comuna;
    private String telefono;
    private Date Fnac;
    private String email;
    private int sexo;
    private String pass;

    public Persona() {
        this.nombre = "";
        this.apellido="";
        this.rut ="";
        this.direccion = "";
        this.comuna = 0;
        this.telefono = "";
        this.Fnac = null;
        this.email = "";
        this.sexo = 0;
        this.pass = "";
    }

    public Persona(String nombre, String rut,String apellido, String direccion, int comuna, String telefono, Date Fnac, String email, int sexo,String pass) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.rut = rut;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.Fnac = Fnac;
        this.email = email;
        this.sexo = sexo;
        this.pass = pass;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFnac() {
        return Fnac;
    }

    public void setFnac(Date Fnac) {
        this.Fnac = Fnac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
    
    
}
