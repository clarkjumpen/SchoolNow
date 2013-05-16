/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Docente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NegocioDocente {

    private Conexion cnn;

    public NegocioDocente() {
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

    public void ingresarDocente(Docente d) {
        this.configurarConexion("docente");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,'"
                + d.getRut() + "','"
                + d.getNombre() + "',"
                + d.getFnac() + ","
                + d.getSexo() + ",'"
                + d.getDireccion() + "',"
                + d.getComuna() + ",'"
                + d.getEmail() + "','"
                + d.getTelefono() + "','"
                + d.getPass() + "',"
                + d.isEsJefe() + ",'"
                + d.getCursoJefe() + "')");
        cnn.conectar();
        cnn.cerrarConexion();
        
    }

    public void eliminarDocente(String rut) {
        this.configurarConexion("Docente");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where rut='" + rut + "'");
        cnn.conectar();
        cnn.cerrarConexion();

    }
    
    public ArrayList<Docente> getDocentes() {
        ArrayList<Docente> lista = new ArrayList();
        this.configurarConexion("Docente");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Docente c = new Docente();
                c.setRut(cnn.getRst().getString("Rut"));
                c.setNombre(cnn.getRst().getString("Nombre"));
                c.setFnac(cnn.getRst().getString("Fnac"));
                c.setSexo(cnn.getRst().getString("Sexo_id_Sexo"));
                c.setDireccion(cnn.getRst().getString("Direccion"));
                c.setComuna(cnn.getRst().getString("Comuna_id_Comuna"));
                c.setEmail(cnn.getRst().getString("Email"));
                c.setTelefono(cnn.getRst().getString("Telefono"));
                c.setPass(cnn.getRst().getString("Pass"));
                c.setEsJefe(cnn.getRst().getBoolean("esJefe"));
                c.setCursoJefe(cnn.getRst().getString("cursoJefe"));
                lista.add(c);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }
    
    public void modificarDocente(Docente c,String buscando) {
        this.configurarConexion("Docente");
        this.cnn.setEsSelect(false);
        System.out.println("rut y wea: " +c.getRut());
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set Rut='" + c.getRut() + "',"
                + "Nombre='" + c.getNombre() + "',"
                + "Fnac=" + c.getFnac() + ","
                + "Sexo_id_Sexo=" + c.getSexo() + ","
                + "Direccion='" + c.getDireccion() + "',"
                + "Comuna_id_Comuna=" + c.getComuna() + ","
                + "Email='" + c.getEmail() + "',"
                + "Telefono='" + c.getTelefono() +"',"
                + "Pass='" + c.getPass()+"',"
                + "esJefe=" + c.isEsJefe()+","
                + "cursoJefe='" + c.getCursoJefe()+"' where Rut='"+ buscando +"'");
        cnn.conectar();
        cnn.cerrarConexion();
       System.out.println(cnn.getSentenciaSql());
    }

    public Docente buscarDocente(String rut) {
        Docente c = new Docente();
        this.configurarConexion("Docente");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where Rut='" + rut + "'");
        cnn.conectar();

        try {
            if (cnn.getRst().next()) {
                c.setRut(cnn.getRst().getString("Rut"));
                c.setNombre(cnn.getRst().getString("Nombre"));
//                c.setFnac(cnn.getRst().getString("Fnac"));
                c.setSexo(cnn.getRst().getString("Sexo_id_Sexo"));
                c.setDireccion(cnn.getRst().getString("Direccion"));
                c.setComuna(cnn.getRst().getString("Comuna_id_Comuna"));
                c.setEmail(cnn.getRst().getString("Email"));
                c.setTelefono(cnn.getRst().getString("Telefono"));
                c.setPass(cnn.getRst().getString("Pass"));
                c.setEsJefe(cnn.getRst().getBoolean("esJefe"));
                c.setCursoJefe(cnn.getRst().getString("cursoJefe"));
                System.out.println("CursoJefe: "  + c.getCursoJefe());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return c;
    }
    
   

    public boolean existeRut(String rut) {
        boolean siEsta = false;

        this.configurarConexion("Docente");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where Rut='" + rut + "'");
        cnn.conectar();


        try {
            if (cnn.getRst().next()) {
                siEsta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return siEsta;
    }

}
