/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashSet;

/**
 *
 * @author netbeans
 */
public class Edificio {
    private String nombreEdificio;

    /*Relacion con Usuario*/
    private HashSet<Usuario> usuarios = new HashSet<>();
    
    /*Relacion con habitacion*/
    private HashSet<Habitacion> habitaciones = new HashSet<>();
    
    public Edificio(String nE){
        this.nombreEdificio = nE;
    }
    
    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public HashSet<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario u) {
        this.usuarios.add(u);
    }
    
    public void quitarUsuario(Usuario u) {
        this.usuarios.remove(u);
    }

    public HashSet<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void agregarHabitacion(Habitacion h) {
        this.habitaciones.add(h);
    }
    
    public void quitarHabitacion(Habitacion h) {
        this.habitaciones.remove(h);
    }
}
