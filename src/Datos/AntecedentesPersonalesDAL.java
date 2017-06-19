/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.AntecedentesPersonales;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class AntecedentesPersonalesDAL {
    
    private static AntecedentesPersonalesDAL instance=new AntecedentesPersonalesDAL();

    private AntecedentesPersonalesDAL() {
    }
    public static AntecedentesPersonalesDAL getInstance()
    {
        return instance;
    }
    public int agregarAntecedentesPersonales(AntecedentesPersonales x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntPer_insertar(?,?,?,?,?)}");
            cs.setDate(1, x.getFecha());
            cs.setString(2, x.getDescripcion());
            cs.setString(3, x.getTratamiento());
            cs.setString(4, x.getEvolucion());
            cs.setInt(5, x.getIdHistoriaClinica());

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarAntecedentesPersonales(AntecedentesPersonales x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntPer_modificar(?,?,?,?,?)}");
            cs.setDate(1, x.getFecha());
            cs.setString(2, x.getDescripcion());
            cs.setString(3, x.getTratamiento());
            cs.setString(4, x.getEvolucion());
            cs.setInt(5, x.getIdHistoriaClinica());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarAntecedentesPersonales(int idHistoriaClinica)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntPer_buscar(?)}");
            cs.setInt(1, idHistoriaClinica);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarAntecedentesPersonales(int idantPersonales, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntPer_eliminar(?,?)}");
            cs.setInt(1, idantPersonales);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
