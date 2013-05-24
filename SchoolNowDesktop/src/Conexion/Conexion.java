/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Conexion {
    //Atributos del API JDBC

    private Connection connect;
    private Statement state;
    private ResultSet rst;
    //Atributos para la coenxion
    private String nombreBaseDatos;
    private String nombreTabla;
    private String driver;
    private String url;
    private String user;
    private String password;
    private String sentenciaSql;
    private boolean esSelect;

    public Conexion(String nombreBaseDatos, String nombreTabla, String driver, String url, String user, String passord, String sentenciaSql, boolean esSelect) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.nombreTabla = nombreTabla;
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = passord;
        this.sentenciaSql = sentenciaSql;
        this.esSelect = esSelect;
    }

    public Conexion() {
        this.nombreBaseDatos = "";
        this.nombreTabla = "";
        this.driver = "";
        this.url = "";
        this.user = "";
        this.password = "";
        this.sentenciaSql = "";
        this.esSelect = false;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public boolean isEsSelect() {
        return esSelect;
    }

    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passord) {
        this.password = passord;
    }

    public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    public String getSentenciaSql() {
        return sentenciaSql;
    }

    public void setSentenciaSql(String sentenciaSql) {
        this.sentenciaSql = sentenciaSql;
    }

    public Statement getState() {
        return state;
    }

    public void setState(Statement state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void cerrarConexion() {
        try {
            this.getConnect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Conexion principal

    public void conectar() {
        //cargar driver de conexion
        try {

            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            //crear conexion
            this.setConnect(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));
            //crear objeto para ejecutar sentencias
            this.setState(this.getConnect().createStatement());



        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        //Preguntar si es query o Stastement
        if (this.isEsSelect() == true) {
            try {
                //Ejecutar una query
                this.setRst(this.getState().executeQuery(this.getSentenciaSql()));
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        } else {
            try {
                //Ejecutar update
                this.getState().executeUpdate(this.getSentenciaSql());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

    }
}

