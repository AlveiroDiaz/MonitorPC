
package Modelo;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Al
 */
public class Pantallazo extends Thread {
    
    public void run(){
        
         
         int cont = 0;
         
         while(true){
             
             //String path= "C://Users//USUARIO//Desktop//Imagenes//"+(cont++)+".jpg";
              String path = "Imagenes/"+(cont++)+".jpg";
            try {
            Robot robotObj = new Robot();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectObj= new Rectangle(dim);
            BufferedImage img = robotObj.createScreenCapture(rectObj);
            ImageIO.write(img, "jpg", new File(path));
            System.out.println("Screenshot Saved.");
            Thread.sleep(12000);
             
        } catch (AWTException | IOException  | InterruptedException ioe) {
            System.out.println(ioe);
        }
        
         }
    
    }
    
}
