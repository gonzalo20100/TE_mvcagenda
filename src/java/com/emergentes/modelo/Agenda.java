
package com.emergentes.modelo;

public class Agenda {       
    private int id;
    private String fecha;
    private String actividad;
    private String estado;
    
    public Agenda(){
        id=0;
        fecha="";
        actividad="";
        estado="";
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
