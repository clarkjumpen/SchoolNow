/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Ramo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NegocioRamo {
      private Conexion cnn;

    public NegocioRamo() {
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

    public ArrayList<Ramo> getRamos() {
        ArrayList<Ramo> lista = new ArrayList();
        this.configurarConexion("Ramo");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Ramo c = new Ramo();
                c.setAsignatura(cnn.getRst().getInt("asignatura_id_asignatura"));
                c.setDocente(cnn.getRst().getInt("Docente_id_Docente"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioRamo.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }

    public boolean existeRamo(String asignatura, String profesor) {
        boolean siEsta = false;

        this.configurarConexion("Ramo");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("select concat(docente.nombre,' ',docente.apellido) as profesor, asignatura.nombre as asignatura from "
                + cnn.getNombreTabla()
                + " inner join asignatura on asignatura_id_Asignatura = id_asignatura inner join docente on docente_id_docente = id_docente where asignatura.nombre='" + asignatura + "' and concat(docente.nombre,' ',docente.apellido)='" + profesor+"'" );
        System.out.println(cnn.getSentenciaSql());
        cnn.conectar();
        try {
            if (cnn.getRst().next()) {
                siEsta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioRamo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return siEsta;
    }

    public void ingresarRamo(Ramo d) {
        this.configurarConexion("Ramo");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,"
                + d.getAsignatura()+"," 
                + d.getDocente()+ ")");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public void modificarRamo(Ramo c, String buscando) {
        this.configurarConexion("Ramo");
        this.cnn.setEsSelect(false);
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set asignatura_id_asignatura='" + c.getAsignatura() +", docente_id_docente=" +c.getDocente() + " where asignatura_id_asignatura="+c.getAsignatura()+" and Docente_id_Docente=" + c.getDocente() );
        cnn.conectar();
        cnn.cerrarConexion();
        System.out.println(cnn.getSentenciaSql());
    }

    public void eliminarRamo(Ramo d) {
        this.configurarConexion("Ramo");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where asignatura_id_asignatura="+d.getAsignatura()+" and Docente_id_Docente=" + d.getDocente() );
        cnn.conectar();
        cnn.cerrarConexion();

    }

   
}
