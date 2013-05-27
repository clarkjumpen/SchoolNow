/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Area;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clark
 */
public class NegocioArea {

    private Conexion cnn;

    public NegocioArea() {
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

    public ArrayList<Area> getAreas() {
        ArrayList<Area> lista = new ArrayList();
        this.configurarConexion("Area");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Area c = new Area();
                c.setArea(cnn.getRst().getString("Area"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }

    public boolean existeArea(String area) {
        boolean siEsta = false;

        this.configurarConexion("Area");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where Area='" + area + "'");
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

    public void ingresarArea(Area d) {
        this.configurarConexion("Area");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,'"
                + d.getArea() + "')");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public void modificarArea(Area c, String buscando) {
        this.configurarConexion("Area");
        this.cnn.setEsSelect(false);
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set Area='" + c.getArea() + "' where Area='" + buscando + "'");
        cnn.conectar();
        cnn.cerrarConexion();
        System.out.println(cnn.getSentenciaSql());
    }

    public void eliminarArea(String nombre) {
        this.configurarConexion("Area");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where Area='" + nombre + "'");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public Area buscarArea(String nombre) {
        Area c = new Area();
        this.configurarConexion("Area");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where Area='" + nombre + "'");
        cnn.conectar();

        try {
            if (cnn.getRst().next()) {
                c.setArea(cnn.getRst().getString("Area"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        cnn.cerrarConexion();
        return c;
    }
}
