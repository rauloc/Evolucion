/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.Especialidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class EspecialidadDAL {
    
    private static EspecialidadDAL instance=new EspecialidadDAL();

    private EspecialidadDAL() {
    }
    public static EspecialidadDAL getInstance()
    {
        return instance;
    }
    public int agregarEspecialidad(Especialidad x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Especialidad_insertar(?,?)}");
            cs.setString(1, x.getDescripcion());
            cs.setString(2, x.getEstado());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarEspecialidad(Especialidad x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Especialidad_modificar(?,?)}");
            cs.setString(1, x.getDescripcion());
            cs.setString(2, x.getEstado());
            
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarEspecialidad(int idEspecialidad)
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Especialidad_buscar(?)}");
            cs.setInt(1, idEspecialidad);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }
    public ResultSet mostrarEspecialidad()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Especialidad_mostrar()}");
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarEspecialidad(int idEspecialidad, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Especialidad_eliminar(?,?)}");
            cs.setInt(1, idEspecialidad);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
