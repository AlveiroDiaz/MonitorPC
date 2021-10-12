/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sonia Pinzón
 */
public class Conexion_BD {

    private Connection conexion;
    private String bd, usuario, clave, mensaje;

    /**
     * Constructor parametrico
     * @param conexion Conexion
     * @param bd Nombre de la base de datos
     * @param usuario Usuario de la base de datos
     * @param clave Clave de la base de datos
     * @param mensaje Mensaje
     */
    public Conexion_BD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }

    /**
     * Constructor parametrico
     */
    public Conexion_BD() {
        this.conexion = null;
        this.bd = "monitor";
        this.usuario = "root";
        this.clave = "";
        this.mensaje = "";
    }

    /**
     * Metodo que hace la conexion a la base de datos
     */
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ruta = "jdbc:mysql://localhost/" + bd;
            System.out.println(ruta);
            conexion = DriverManager.getConnection(ruta, usuario, clave);
            mensaje = "Conexión exitosa...";
        } catch (ClassNotFoundException ex) {
            mensaje = "No se pudo establecer conexion...";
        } catch (SQLException ex) {
            mensaje = " No se puede conectar con MySQL...";
        }
    }

    /**
     * Metodo que retorna los atributos de la clase en formato texto
     * @return String
     */
    @Override
    public String toString() {
        return "Conexion{" + "conexion=" + conexion + ", bd=" + bd + ", usuario=" + usuario + ", clave=" + clave + ", mensaje=" + mensaje + '}';
    }

    /**
     * Retorna una instancia de conexion
     * @return Connection
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Establece o modifica la instancia de conexion
     * @param conexion Conexion
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Retorna el nombre de la base de datos
     * @return String
     */
    public String getBd() {
        return bd;
    }

    /**
     * Establece o modifica el nombre de la base de datos
     * @param bd nombre de la base de datos
     */
    public void setBd(String bd) {
        this.bd = bd;
    }

    /**
     * Retorna el usuario de la base de datos
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece o modifica el usuario de la base de datos
     * @param usuario Usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna la clave de la base de datos
     * @return String
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece o modifica la clave de la base de datos
     * @param clave clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Retorna el mensaje
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece  o modifica el mensaje
     * @param mensaje Mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
