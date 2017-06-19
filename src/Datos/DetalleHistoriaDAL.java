/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.DetalleHistoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class DetalleHistoriaDAL {
    
    private static DetalleHistoriaDAL instance=new DetalleHistoriaDAL();

    private DetalleHistoriaDAL() {
    }
    public static DetalleHistoriaDAL getInstance()
    {
        return instance;
    }
    public int agregarDetalleHistoria(DetalleHistoria x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call DetHist_insertar(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, x.getEmfermedadActual());
            cs.setString(2, x.getFC());
            cs.setDouble(3, x.getPeso());
            cs.setString(4, x.getPA());
            cs.setDouble(5, x.getTalla());
            cs.setDouble(6, x.getTemperatura());
            cs.setString(7, x.getExamenesAuxiliares());
            cs.setString(8, x.getDiagnostico());
            cs.setString(9, x.getTratamiento());
            cs.setString(10, x.getEvolucion());
            cs.setDate(11, x.getFecha());
            cs.setInt(12, x.getIdHistoriaClinica());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarDetalleHistoria(DetalleHistoria x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call DetHist_modificar(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, x.getEmfermedadActual());
            cs.setString(2, x.getFC());
            cs.setDouble(3, x.getPeso());
            cs.setString(4, x.getPA());
            cs.setDouble(5, x.getTalla());
            cs.setDouble(6, x.getTemperatura());
            cs.setString(7, x.getExamenesAuxiliares());
            cs.setString(8, x.getDiagnostico());
            cs.setString(9, x.getTratamiento());
            cs.setString(10, x.getEvolucion());
            cs.setDate(11, x.getFecha());
            cs.setInt(12, x.getIdHistoriaClinica());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarDetalleHistoria(int idHistoriaClinica)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call DetHist_buscar(?)}");
            cs.setInt(1, idHistoriaClinica);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarDetalleHistoria(int idDetalleHistoria, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call DetHist_eliminar(?,?)}");
            cs.setInt(1, idDetalleHistoria);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
