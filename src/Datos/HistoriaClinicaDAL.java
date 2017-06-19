/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.HistoriaClinica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class HistoriaClinicaDAL {
    
    private static HistoriaClinicaDAL instance=new HistoriaClinicaDAL();

    private HistoriaClinicaDAL() {
    }
    public static HistoriaClinicaDAL getInstance()
    {
        return instance;
    }
    public int agregarHistoriaClinica(HistoriaClinica x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call HistCli_insertar(?,?)}");
            cs.setDate(1, x.getFechaUltimaActualizacion());
            cs.setInt(2, x.getIdPaciente());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarHistoriaClinica(HistoriaClinica x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call HistCli_modificar(?,?,?,?,?,?)}");
            cs.setDate(1, x.getFechaUltimaActualizacion());
            cs.setInt(2, x.getIdPaciente());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarHistoriaClinica(int idHistoriaclinica)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call HistCli_buscar(?)}");
            cs.setInt(1, idHistoriaclinica);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarHistoriaClinica(int idHistoriaclinica, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call HistCli_eliminar(?,?)}");
            cs.setInt(1, idHistoriaclinica);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
