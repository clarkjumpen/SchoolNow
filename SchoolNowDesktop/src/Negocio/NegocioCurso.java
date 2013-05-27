/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NegocioCurso {
    private Conexion cnn;

    public NegocioCurso() {
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

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> lista = new ArrayList();
        this.configurarConexion("Curso");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Curso c = new Curso();
                c.setNombre(cnn.getRst().getString("nombre"));
                c.setProfesorJefe(cnn.getRst().getString("ProfesorJefe"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }

    public boolean existeCurso(String Curso) {
        boolean siEsta = false;

        this.configurarConexion("Curso");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where nombre='" + Curso + "'");
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                siEsta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioCurso.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return siEsta;
    }

    public void ingresarCurso(Curso d) {
        this.configurarConexion("Curso");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,'"
                + d.getNombre() +"','"
                + d.getProfesorJefe()+ "')");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public void modificarCurso(Curso c, String buscando) {
        this.configurarConexion("Curso");
        this.cnn.setEsSelect(false);
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set nombre='" + c.getNombre() + ",profesorJefe='"+c.getProfesorJefe()+"' where nombre='" + buscando + "'");
        cnn.conectar();
        cnn.cerrarConexion();
        System.out.println(cnn.getSentenciaSql());
    }

    public void eliminarCurso(String nombre) {
        this.configurarConexion("Curso");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where nombre='" + nombre + "'");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public Curso buscarCurso(String nombre) {
        Curso c = new Curso();
        this.configurarConexion("Curso");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where nombre='" + nombre + "'");
        cnn.conectar();

        try {
            if (cnn.getRst().next()) {
                c.setNombre(cnn.getRst().getString("nombre"));
                c.setProfesorJefe(cnn.getRst().getString("profesorJefe"));
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
