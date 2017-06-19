/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 *
 * @author Giancarlo
 */
public class Especialidad {
    
    private int idEspecialidad;
    private String Descripcion;
    private String Estado;
    private Lista listaDoctor;

    public Especialidad() {
    }

    public Especialidad(int idEspecialidad, String Descripcion, String Estado) {
        this.idEspecialidad = idEspecialidad;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

}
