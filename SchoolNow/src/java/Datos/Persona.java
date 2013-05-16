/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ssony
 */
public class Persona {

    private String nombre;
    private String rut;
    private String direccion;
    private String comuna;
    private String telefono;
    private String Fnac;
    private String email;
    private String sexo;
    private String pass;

    public Persona() {
        this.nombre = "";
        this.rut = "";
        this.direccion = "";
        this.comuna = "";
        this.telefono = "";
        this.Fnac = "";
        this.email = "";
        this.sexo = "";
        this.pass = "";
    }

    public Persona(String nombre, String rut, String direccion, String comuna, String telefono, String Fnac, String email, String sexo,String pass) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.Fnac = Fnac;
        this.email = email;
        this.sexo = sexo;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
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

    public String getFnac() {
        return Fnac;
    }

    public void setFnac(String Fnac) {
        this.Fnac = Fnac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
