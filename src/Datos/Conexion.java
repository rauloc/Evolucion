/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Conexion {
    
    private static Conexion instance=new Conexion();

    private Conexion()
    {
    }
    public static Conexion getInstance()
    {
        return instance;
    }
    public Connection getConnection()
    {
        Connection cn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex){

        }
        try{
            String url="jdbc:mysql://localhost:3306/bdclinica";
            String user="root";
            String password="123456";
            cn=DriverManager.getConnection(url, user, password);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }
}
