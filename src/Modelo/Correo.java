/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Al
 */
public class Correo extends Thread {

    public void enviarCorreo() throws MessagingException {

        String correo = "andresuarique@gmail.com";
        String pass = "qydzzujiodvgesrw";// *-*                                                           
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        BodyPart texto = new MimeBodyPart();
        texto.setText("Mensaje con cosas");
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource("Imagenes.zip")));
        adjunto.setFileName("Imagenes.zip");
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);

        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correo));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("andresuarique@gmail.com"));
        mensaje.setSubject("Hola mi perro");
        mensaje.setContent(m);

        Transport t = s.getTransport("smtp");
        t.connect(correo, pass);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
        System.out.println("Correo Enviado");
    }

    public void run() {

        try {
            Thread.sleep(35000);
            enviarCorreo();
        } catch (InterruptedException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
