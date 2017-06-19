/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.sql.Date;


/**
 *
 * @author Giancarlo
 */
public class Paciente {
    
    private int idPaciente;
    private int idDoctor;
    private String Nombres;
    private String Apellidos;
    private String Ocupacion;
    private Date FechaNacimiento;
    private String Sexo;
    private String Direccion;
    private String Telefono;
    private String Email;
    private Date FechaRegistro;
    private String Raza;
    private String Estado;
    private HistoriaClinica historiaclinica;

    public Paciente() {
    }
    
    
    public Paciente(int idPaciente, int idDoctor, String Nombres, String Apellidos, String Ocupacion, Date FechaNacimiento, String Sexo, String Direccion, String Telefono, String Email, Date FechaRegistro, String Raza, String Estado, HistoriaClinica historiaclinica) {
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Ocupacion = Ocupacion;
        this.FechaNacimiento = FechaNacimiento;
        this.Sexo = Sexo;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.FechaRegistro = FechaRegistro;
        this.Raza = Raza;
        this.Estado = Estado;
        this.historiaclinica = historiaclinica;
        
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public void setOcupacion(String Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public HistoriaClinica getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(HistoriaClinica historiaclinica) {
        this.historiaclinica = historiaclinica;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

}
