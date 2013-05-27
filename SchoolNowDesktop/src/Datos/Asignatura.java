/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author usuario
 */
public class Asignatura {

    private String nombre;
    private int area;

    public Asignatura() {
        this.nombre = "";
        this.area = 0;
    }

    public Asignatura(String nombre, int area) {

        this.nombre = nombre;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
