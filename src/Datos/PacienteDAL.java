/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Entidades.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Giancarlo
 */
public class PacienteDAL {
   
    private static PacienteDAL instance=new PacienteDAL();

    private PacienteDAL() {
    }
    public static PacienteDAL getInstance()
    {
        return instance;
    }
    public int agregarPaciente(Paciente x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_insertar(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, x.getNombres());
            cs.setString(2, x.getApellidos());
            cs.setString(3, x.getOcupacion());
            cs.setDate(4,x.getFechaNacimiento());
            cs.setString(5, x.getSexo());
            cs.setString(6, x.getDireccion());
            cs.setString(7, x.getTelefono());
            cs.setString(8, x.getEmail());
            cs.setDate(9,x.getFechaRegistro());
            cs.setString(10, x.getRaza());
            cs.setString(11, x.getEstado());
            cs.setInt(12, x.getIdDoctor());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
    public int modificarPaciente(Paciente x)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_modificar(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, x.getNombres());
            cs.setString(2, x.getApellidos());
            cs.setString(3, x.getOcupacion());
            cs.setDate(4, x.getFechaNacimiento());
            cs.setString(5, x.getSexo());
            cs.setString(6, x.getDireccion());
            cs.setString(7, x.getTelefono());
            cs.setString(8, x.getEmail());
            cs.setString(9, x.getRaza());
            cs.setString(10, x.getEstado());
            cs.setInt(11, x.getIdPaciente());
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }

    public ResultSet buscarPaciente(int idPaciente)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_buscar(?)}");
            cs.setInt(1, idPaciente);
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }
    public ResultSet Id()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_Id()}");
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }
    public ResultSet mostrarPacientes()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_mostrar()}");
            ResultSet rs=cs.executeQuery();
            return rs;
        }catch(Exception ex){return null;}
    }
    public int cantidadPacientes()
    {
        Connection cn=Conexion.getInstance().getConnection();
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_mostrar()}");
            ResultSet rs=cs.executeQuery();
            int i=0;
            while(rs.next()){i++;}
            return i;
        }catch(Exception ex){return -1;}
    }

    public int eliminarPaciente(int idPaciente, String estado)
    {
        Connection cn=Conexion.getInstance().getConnection();
        int n=-1;
        try{
            CallableStatement cs=cn.prepareCall("{call Paciente_eliminar(?,?)}");
            cs.setString(1, estado);
            cs.setInt(2, idPaciente);
            n=cs.executeUpdate();
        }catch(Exception ex){n=-1;}
        return n;
    }
}
