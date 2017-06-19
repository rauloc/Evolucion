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
public class DetalleHistoria {
    public int idDetalleHistoria;
    public String EmfermedadActual;
    public String FC;
    public double Peso;
    public String PA;
    public double Talla;
    public double Temperatura;
    public String ExamenesAuxiliares;
    public String Diagnostico;
    public String Tratamiento;
    public String Evolucion;
    public Date Fecha;
    public int idHistoriaClinica;

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getEmfermedadActual() {
        return EmfermedadActual;
    }

    public void setEmfermedadActual(String EmfermedadActual) {
        this.EmfermedadActual = EmfermedadActual;
    }

    public String getEvolucion() {
        return Evolucion;
    }

    public void setEvolucion(String Evolucion) {
        this.Evolucion = Evolucion;
    }

    public String getExamenesAuxiliares() {
        return ExamenesAuxiliares;
    }

    public void setExamenesAuxiliares(String ExamenesAuxiliares) {
        this.ExamenesAuxiliares = ExamenesAuxiliares;
    }

    public String getFC() {
        return FC;
    }

    public void setFC(String FC) {
        this.FC = FC;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getPA() {
        return PA;
    }

    public void setPA(String PA) {
        this.PA = PA;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getTalla() {
        return Talla;
    }

    public void setTalla(double Talla) {
        this.Talla = Talla;
    }

    public double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(double Temperatura) {
        this.Temperatura = Temperatura;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public int getIdDetalleHistoria() {
        return idDetalleHistoria;
    }

    public void setIdDetalleHistoria(int idDetalleHistoria) {
        this.idDetalleHistoria = idDetalleHistoria;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }
    
}
