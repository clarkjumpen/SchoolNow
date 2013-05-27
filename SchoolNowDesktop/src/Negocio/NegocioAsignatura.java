/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Asignatura;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NegocioAsignatura {

    private Conexion cnn;

    public NegocioAsignatura() {
        this.cnn = new Conexion();
    }

    private void configurarConexion(String nombreTable) {
        cnn.setNombreBaseDatos("Escuela");
        cnn.setNombreTabla(nombreTable);

        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setUrl("jdbc:mysql://localhost:3306/"
                + cnn.getNombreBaseDatos());

        cnn.setUser("root");
        cnn.setPassword("123456");

    }

    public void ingresarAsignatura(Asignatura d) {
        this.configurarConexion("Asignatura");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,'"
                + d.getNombre() + "',"
                + d.getArea() + ")");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public void modificarAsignatura(Asignatura c, String buscando) {
        this.configurarConexion("Asignatura");
        this.cnn.setEsSelect(false);
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set Nombre='" + c.getNombre() + "',"
                + "Area_id_Area=" + c.getArea() + " where nombre='" + buscando + "'");
        cnn.conectar();
        cnn.cerrarConexion();
        System.out.println(cnn.getSentenciaSql());
    }

    public void eliminarAsignatura(String nombre) {
        this.configurarConexion("Asignatura");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where nombre='" + nombre + "'");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public boolean existeAsignatura(String nombre) {
        boolean siEsta = false;

        this.configurarConexion("Asignatura");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where nombre='" + nombre + "'");
        cnn.conectar();


        try {
            if (cnn.getRst().next()) {
                siEsta = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return siEsta;
    }

    public Asignatura buscarAsignatura(String nombre) {
        Asignatura c = new Asignatura();
        this.configurarConexion("Asignatura");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where nombre='" + nombre + "'");
        cnn.conectar();

        try {
            if (cnn.getRst().next()) {
                c.setArea(cnn.getRst().getInt("Area_id_Area"));
                c.setNombre(cnn.getRst().getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        cnn.cerrarConexion();
        return c;
    }
    
    public ArrayList<Asignatura> getAsignaturas() {
        ArrayList<Asignatura> lista = new ArrayList();
        this.configurarConexion("Asignatura");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Asignatura c = new Asignatura();
                c.setNombre(cnn.getRst().getString("Nombre"));
                c.setArea(cnn.getRst().getInt("Area_id_Area"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }
}
