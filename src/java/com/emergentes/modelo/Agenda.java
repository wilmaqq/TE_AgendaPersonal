package com.emergentes.modelo;

/**
 *
 * @author YURIKIRA105
 */



public class Agenda {
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String hora;
    private String actividad;
    private String estado;

    
    public Agenda() {
        id = 0;
        hora = "";
        actividad = "";
        estado = "";
        nombres="";
        apellidos="";
        edad=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
