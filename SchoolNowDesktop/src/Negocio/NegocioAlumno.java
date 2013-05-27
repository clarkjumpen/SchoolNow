/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import Datos.Alumno;
import Datos.Comuna;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NegocioAlumno {

    private Conexion cnn;

    public NegocioAlumno() {
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

    public String getPassword(String rut) {
        this.configurarConexion("Alumno");
        cnn.setEsSelect(true);
        cnn.setSentenciaSql("Select Pass from " + cnn.getNombreTabla() + " where Rut='" + rut + "'");
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                return cnn.getRst().getString("Pass");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioAlumno.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return null;
    }

    public void setContraseña(Alumno d, String contraseña) {
        this.configurarConexion("Alumno");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("update "
                + cnn.getNombreTabla()
                + " set Pass ='" + contraseña + "' where Rut='" + d.getRut() + "'");
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public Alumno getAlumno(String rut) {
        this.configurarConexion("Alumno");
        cnn.setEsSelect(true);
        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla() + " where Rut='" + rut + "'");
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Alumno c = new Alumno();
                c.setRut(cnn.getRst().getString("Rut"));
                c.setNombre(cnn.getRst().getString("Nombre"));
                c.setApellido(cnn.getRst().getString("apellido"));
                c.setFnac(cnn.getRst().getDate("Fnac"));
                c.setSexo(cnn.getRst().getInt("Sexo_id_Sexo"));
                c.setDireccion(cnn.getRst().getString("Direccion"));
                c.setComuna(cnn.getRst().getInt("Comuna_id_Comuna"));
                c.setEmail(cnn.getRst().getString("Email"));
                c.setTelefono(cnn.getRst().getString("Telefono"));
                c.setPass(cnn.getRst().getString("Pass"));
                c.setEstado(cnn.getRst().getInt("Estado_id_Estado"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioAlumno.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return null;
    }

    public void ingresarAlumno(Alumno d) {
        this.configurarConexion("Alumno");
        cnn.setEsSelect(false);
        cnn.setSentenciaSql("insert into "
                + cnn.getNombreTabla()
                + " values(0,'"
                + d.getRut() + "','"
                + d.getNombre() + "','"
                + d.getApellido() + "','"
                + this.toStringDate(d.getFnac()) + "',"
                + d.getSexo() + ",'"
                + d.getDireccion() + "',"
                + d.getComuna() + ",'"
                + d.getEmail() + "','"
                + d.getTelefono() + "','"
                + d.getPass() + "',"
                + d.getEstado() +")");
        System.out.println(cnn.getSentenciaSql());
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public void eliminarAlumno(String rut) {
        this.configurarConexion("Alumno");

        cnn.setEsSelect(false);
        cnn.setSentenciaSql("Delete from "
                + cnn.getNombreTabla()
                + " where rut='" + rut + "'");
        cnn.conectar();
        cnn.cerrarConexion();

    }

    public ArrayList<Alumno> getAlumno() {
        ArrayList<Alumno> lista = new ArrayList();
        this.configurarConexion("Alumno");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from " + cnn.getNombreTabla());
        cnn.conectar();
        try {
            while (cnn.getRst().next()) {
                Alumno c = new Alumno();
                c.setRut(cnn.getRst().getString("Rut"));
                c.setNombre(cnn.getRst().getString("Nombre"));
                c.setApellido(cnn.getRst().getString("apellido"));
                c.setFnac(cnn.getRst().getDate("Fnac"));
                c.setSexo(cnn.getRst().getInt("Sexo_id_Sexo"));
                c.setDireccion(cnn.getRst().getString("Direccion"));
                c.setComuna(cnn.getRst().getInt("Comuna_id_Comuna"));
                c.setEmail(cnn.getRst().getString("Email"));
                c.setTelefono(cnn.getRst().getString("Telefono"));
                c.setPass(cnn.getRst().getString("Pass"));
                c.setEstado(cnn.getRst().getInt("Estado_id_Estado"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioAlumno.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return lista;
    }

    public void modificarAlumno(Alumno c, String buscando) {
        this.configurarConexion("Alumno");
        this.cnn.setEsSelect(false);
        System.out.println("rut y wea: " + c.getRut());
        cnn.setSentenciaSql("Update "
                + cnn.getNombreTabla()
                + " set Rut='" + c.getRut() + "',"
                + "Nombre='" + c.getNombre() + "',"
                + "Apellido='" + c.getApellido() + "',"
                + "Fnac='" + this.toStringDate(c.getFnac()) + "',"
                + "Sexo_id_Sexo=" + c.getSexo() + ","
                + "Direccion='" + c.getDireccion() + "',"
                + "Comuna_id_Comuna=" + c.getComuna() + ","
                + "Email='" + c.getEmail() + "',"
                + "Telefono='" + c.getTelefono() +"',"
                + "Estado_id_estado=" +c.getEstado()+" where Rut='" + buscando + "'");
        cnn.conectar();
        cnn.cerrarConexion();
        System.out.println(cnn.getSentenciaSql());
    }

    public Alumno buscarAlumno(String rut) {
        Alumno c = new Alumno();
        this.configurarConexion("Alumno");
        cnn.setEsSelect(true);

        cnn.setSentenciaSql("Select * from "
                + cnn.getNombreTabla()
                + " where Rut='" + rut + "'");
        cnn.conectar();

        try {
            if (cnn.getRst().next()) {
                c.setRut(cnn.getRst().getString("Rut"));
                c.setNombre(cnn.getRst().getString("Nombre"));
                c.setApellido(cnn.getRst().getString("Apellido"));
                c.setFnac(cnn.getRst().getDate("Fnac"));
                c.setSexo(cnn.getRst().getInt("Sexo_id_Sexo"));
                c.setDireccion(cnn.getRst().getString("Direccion"));
                c.setComuna(cnn.getRst().getInt("Comuna_id_Comuna"));
                c.setEmail(cnn.getRst().getString("Email"));
                c.setTelefono(cnn.getRst().getString("Telefono"));
                c.setPass(cnn.getRst().getString("Pass"));
                c.setEstado(cnn.getRst().getInt("Estado_id_Estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioAlumno.class
                    .getName()).log(Level.SEVERE, null, ex);



            return null;
        }
        cnn.cerrarConexion();
        return c;
    }

    public boolean existeRut(String rut) {
        boolean siEsta = false;

        this.configurarConexion("Alumno");
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
            Logger.getLogger(NegocioAlumno.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cnn.cerrarConexion();
        return siEsta;
    }

    private String toStringDate(java.util.Date date) {
        DateFormat df;
        String dateString;
        df = new SimpleDateFormat("yyyy/MM/dd");
        dateString = df.format(date);
        return dateString;
    }
}
