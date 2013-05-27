/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author usuario
 *
 * // RECORDAR USAR private ALUMNO alumno; etc
 */
public class Seccion {

    private String nombre;
    private int asignatura;
    private int alumno;
    private int docente;

    public Seccion() {
        this.nombre = "";
        this.asignatura = 0;
        this.alumno = 0;
        this.docente = 0;
    }

    public Seccion(String nombre, int asignatura, int alumno, int docente) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.alumno = alumno;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }
}
