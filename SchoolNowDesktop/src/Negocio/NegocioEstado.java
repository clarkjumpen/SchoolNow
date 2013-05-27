/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Comuna;
import Datos.Estado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clark
 */
public class NegocioEstado {
       
 private Conexion cnn;

    public NegocioEstado() {
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

    public ArrayList<Estado> getEstados() {
        ArrayList<Estado> lista = new ArrayList();
        this.configurarConexion("Estado");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Estado c = new Estado();
                c.setEstado(cnn.getRst().getString("Estado"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }
}
