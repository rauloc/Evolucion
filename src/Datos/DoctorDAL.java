/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.Doctor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class DoctorDAL {
    
    private static DoctorDAL instance=new DoctorDAL();

    private DoctorDAL() {
    }
    public static DoctorDAL getInstance()
    {
        return instance;
    }
    public int agregarDoctor(Doctor x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_insertar(?,?,?,?,?,?)}");
            cs.setString(1, x.getNombres());
            cs.setString(2, x.getApellidos());
            cs.setString(3, x.getUsuario());
            cs.setString(4, x.getPass());
            cs.setString(5, x.getEstado());
            cs.setInt(6, x.getIdEspecialidad());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarDoctor(Doctor x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_modificar(?,?,?,?,?,?,?)}");
            cs.setString(1, x.getNombres());
            cs.setString(2, x.getApellidos());
            cs.setString(3, x.getUsuario());
            cs.setString(4, x.getPass());
            cs.setString(5, x.getEstado());
            cs.setInt(6, x.getIdEspecialidad());
            cs.setInt(7, x.getIdDoctor());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public Doctor buscarDoctor(int idDoctor)
    {
        Connection cn=Conexion.getInstance().getConnection();
        Doctor doctor=null;
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_buscar(?)}");
            cs.setInt(1, idDoctor);
            ResultSet rs=cs.executeQuery();
            while(rs.next())
            {
                doctor=new Doctor(rs.getInt(1), rs.getInt(7),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            return doctor;
        }catch(Exception ex){return null;}
    }
    public int cantidadDoctores()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_mostrar()}");
            ResultSet rs=cs.executeQuery();
            int i=0;
            while(rs.next())
            {
                i++;   
            }
            return i;
        }catch(Exception ex){return -1;}
    }
    public ResultSet mostrarDoctor()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_mostrar()}");
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }
    public ResultSet buscarDoctorUserPass(String usuario,String pass)
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_buscarUserPass(?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, pass);
            ResultSet rs=cs.executeQuery();
            System.out.print("1");
            return rs;
        }catch(Exception ex){return null;}
    }
    public ResultSet buscarDoctorUsuario(String usuario)
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_buscarUsuario(?)}");
            cs.setString(1, usuario);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarDoctor(int idDoctor, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Doctor_eliminar(?,?)}");
            cs.setInt(1, idDoctor);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
