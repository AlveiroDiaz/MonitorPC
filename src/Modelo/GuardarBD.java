/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author USUARIO
 */
public class GuardarBD{
    public void guardar(){
        Conexion_BD conexion = new Conexion_BD();
        File archivo = new File("imagenes.zip");
        long longitud = archivo.length();
    
        try {
            
            InetAddress ip= InetAddress.getLocalHost();
            FileInputStream flujo = new FileInputStream(archivo);
            conexion.conectar();
            PreparedStatement ps=conexion.getConexion().prepareStatement("insert into registro (id, pc, archivo) values (null, ?,?)");
            ps.setString(1, ip.getHostAddress());
            ps.setBlob(2, flujo, longitud);
            ps.execute();
            conexion.getConexion().close();
            System.out.println("Archivo Subido");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuardarBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GuardarBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GuardarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}
