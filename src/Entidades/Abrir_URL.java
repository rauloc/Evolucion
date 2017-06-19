/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN CARLOS
 */
public class Abrir_URL {
    


    public void Open(){
        if(java.awt.Desktop.isDesktopSupported()){
            try{
                Desktop dk = Desktop.getDesktop();
                dk.browse(new URI("http://www.miprimercodigo.com"));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR: No se pudo abrir URL " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
}
