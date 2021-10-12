/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spyware;

import Control.Controlador;
import java.io.IOException;
import javax.mail.MessagingException;

/**
 * hola
 *
 * @author TEST OLA UNO 1 2 3 5 8 13
 */
public class Spyware extends Thread {

    public Spyware() {

    }

    /**
     * @param args the command line arguments test124514144144 HOLA YO SOYasdadgdf
     * ANDRES SUARIQUE
     * @throws java.io.IOException comdiaCOMIDA
     */
    public static void main(String[] args) throws IOException, MessagingException, InterruptedException {

        Controlador control = new Controlador();
        control.iniciar();

    }
}
