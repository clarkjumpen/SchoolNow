/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clark
 */
public class NegocioUsuario {

    private Conexion cnn;

    public NegocioUsuario() {
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

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new ArrayList();
        this.configurarConexion("usuarios");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Usuario c = new Usuario();
                c.setUser(cnn.getRst().getString("user"));
                c.setPass(cnn.getRst().getString("pass"));
                c.setNivel(cnn.getRst().getInt("nivel"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }
}
