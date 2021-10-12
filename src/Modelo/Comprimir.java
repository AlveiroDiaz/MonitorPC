package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Al
 */
public class Comprimir extends Thread {

    public void agregarCarpeta(String ruta, String carpeta, ZipOutputStream zip) throws Exception {
        File directorio = new File(carpeta);
        for (String nombreArchivo : directorio.list()) {
            if (ruta.equals("")) {
                agregarArchivo(directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            } else {
                agregarArchivo(ruta + "/" + directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            }
        }
    }

    public void agregarArchivo(String ruta, String directorio, ZipOutputStream zip) throws Exception {
        File archivo = new File(directorio);
        if (archivo.isDirectory()) {
            agregarCarpeta(ruta, directorio, zip);
        } else {
            byte[] buffer = new byte[4096];
            int leido;
            FileInputStream entrada = new FileInputStream(archivo);
            zip.putNextEntry(new ZipEntry(ruta + "/" + archivo.getName()));
            while ((leido = entrada.read(buffer)) > 0) {
                zip.write(buffer, 0, leido);
            }
        }
    }

    public void comprimir(String archivo, String archivoZIP) throws Exception {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(archivoZIP));
        agregarCarpeta("", archivo, zip);
        zip.flush();
        zip.close();
    }

    public void Correr() throws Exception {
        Comprimir comp = new Comprimir();
        File directorio = new File("Imagenes/Datos.txt");
        File archivoSeleccionado = directorio;
        String parent = archivoSeleccionado.getParent();
        String nuevoParent = parent.replaceAll("\\\\", "\\\\\\\\");
        String destino = nuevoParent + ".zip";
        comp.comprimir(nuevoParent, destino);
        System.out.println("Se comprimio correctamente");
    }

    public void run() {
        try {
            Thread.sleep(30000);
            Correr();
            GuardarBD guardar= new GuardarBD();
            guardar.guardar();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Comprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
