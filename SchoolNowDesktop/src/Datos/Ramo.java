/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author usuario
 */
public class Ramo {
    private int asignatura;
    private int docente;

    public Ramo() {
        this.asignatura = 0;
        this.docente = 0;
    }

    public Ramo(int asignatura, int docente) {
        this.asignatura = asignatura;
        this.docente = docente;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }
    
    
    
}
