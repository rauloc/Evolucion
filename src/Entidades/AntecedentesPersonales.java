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
public class AntecedentesPersonales {
    public int idAntPersonales;
    public Date Fecha;
    public String Descripcion;
    public String Tratamiento;
    public String Evolucion;
    public int idHistoriaClinica;

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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public int getIdAntPersonales() {
        return idAntPersonales;
    }

    public void setIdAntPersonales(int idAntPersonales) {
        this.idAntPersonales = idAntPersonales;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

}
