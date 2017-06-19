/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.AntecedentesFamiliares;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class AntecedentesFamiliaresDAL {
    
    private static AntecedentesFamiliaresDAL instance=new AntecedentesFamiliaresDAL();

    private AntecedentesFamiliaresDAL() {
    }
    public static AntecedentesFamiliaresDAL getInstance()
    {
        return instance;
    }
    public int agregarAntecedentesFamiliares(AntecedentesFamiliares x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntFam_insertar(?,?,?,?,?,?,?)}");
            cs.setString(1, x.getParentezco());
            cs.setString(2, x.getNombres());
            cs.setString(3, x.getApellidos());
            cs.setString(4, x.getDescripcion());
            cs.setString(5, x.getTratamiento());
            cs.setString(6, x.getEvolucion());
            cs.setInt(7, x.getIdHistoriaClinica());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarAntecedentesFamiliares(AntecedentesFamiliares x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntFam_modificar(?,?,?,?,?,?,?)}");
            cs.setString(1, x.getParentezco());
            cs.setString(2, x.getNombres());
            cs.setString(3, x.getApellidos());
            cs.setString(4, x.getDescripcion());
            cs.setString(5, x.getTratamiento());
            cs.setString(6, x.getEvolucion());
            cs.setInt(7, x.getIdHistoriaClinica());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarAntecedentesFamiliares(int idHistoriaClinica)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntFam_buscar(?)}");
            cs.setInt(1, idHistoriaClinica);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }

    public int eliminarAntecedentesFamiliares(int idantFamiliares, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call AntFam_eliminar(?,?)}");
            cs.setInt(1, idantFamiliares);
            cs.setString(2, estado);

            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
