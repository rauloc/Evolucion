/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 *
 * @author Giancarlo
 */
public class Doctor {
    
    private int idDoctor;
    private int idEspecialidad;
    private String Nombres;
    private String Apellidos;
    private String Usuario;
    private String Pass;
    private String Estado;
    private Lista listaPaciente;

    public Doctor()
    {
    }

    public Doctor(int idDoctor, int idEspecialidad, String Nombres, String Apellidos, String Usuario, String Pass, String Estado) {
        this.idDoctor = idDoctor;
        this.idEspecialidad = idEspecialidad;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Usuario = Usuario;
        this.Pass = Pass;
        this.Estado = Estado;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

}
