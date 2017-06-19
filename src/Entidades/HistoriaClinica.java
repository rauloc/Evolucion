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
public class HistoriaClinica {
    
    private int idHistoriaClinica;
    private Date FechaUltimaActualizacion;
    private int idPaciente;
    private Lista listaAnteP;
    private Lista listaAnteF;
    private Lista listaDetalleHistorial;


    public HistoriaClinica() {
    }

    public HistoriaClinica(int idHistoriaClinica, Date FechaUltimaActualizacion, int idPaciente) {
        this.idHistoriaClinica = idHistoriaClinica;
        this.FechaUltimaActualizacion = FechaUltimaActualizacion;
        this.idPaciente = idPaciente;
        listaAnteP=new Lista();
        listaAnteF=new Lista();
        listaDetalleHistorial=new Lista();
    }

    public boolean agregaAntecedentesP(AntecedentesPersonales x)
    {
        return listaAnteP.agregar(x);
    }
    public boolean agregarAntecedentesF(AntecedentesFamiliares x)
    {
        return listaAnteF.agregar(x);
    }
    public boolean agregarDetalleHistorial(DetalleHistoria x)
    {
        return listaDetalleHistorial.agregar(x);
    }

    public Lista getListaAnteF() {
        return listaAnteF;
    }

    public Lista getListaAnteP() {
        return listaAnteP;
    }

    public Lista getListaDetalleHistorial() {
        return listaDetalleHistorial;
    }
    
    public Date getFechaUltimaActualizacion() {
        return FechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date FechaUltimaActualizacion) {
        this.FechaUltimaActualizacion = FechaUltimaActualizacion;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }


}
