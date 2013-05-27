/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author usuario
 */
public class Curso {

    private String nombre;
    private String profesorJefe;

    public Curso(String nombre, String profesorJefe) {
        this.nombre = nombre;
        this.profesorJefe = profesorJefe;
    }

    public Curso() {
        this.nombre = "";
        this.profesorJefe = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesorJefe() {
        return profesorJefe;
    }

    public void setProfesorJefe(String profesorJefe) {
        this.profesorJefe = profesorJefe;
    }
}
