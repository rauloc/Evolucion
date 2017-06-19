/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 *
 * @author Giancarlo
 */
public class AntecedentesFamiliares {
    public int idAntFamiliares;
    public String Parentezco;
    public String Nombres;
    public String Apellidos;
    public String Descripcion;
    public String Tratamiento;
    public String Evolucion;
    public int idHistoriaClinica;

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEvolucion() {
        return Evolucion;
    }

    public void setEvolucion(String Evolucion) {
        this.Evolucion = Evolucion;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getParentezco() {
        return Parentezco;
    }

    public void setParentezco(String Parentezco) {
        this.Parentezco = Parentezco;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public int getIdAntFamiliares() {
        return idAntFamiliares;
    }

    public void setIdAntFamiliares(int idAntFamiliares) {
        this.idAntFamiliares = idAntFamiliares;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }
    
}
