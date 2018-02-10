/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author netbeans
 */
public class Habitacion {
    private String nombreHabitacion;
    
    /*Relacion con Edificio*/
    private Edificio edificio;

    /*Relacion con TipoAparato*/
    private ArrayList<TipoAparato> tiposAparatos = new ArrayList<>();
    
    public Habitacion(String nH, Edificio e) {
        this.nombreHabitacion = nH;
        this.edificio = e;
    }
    
    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public ArrayList<TipoAparato> getTiposAparatos() {
        return tiposAparatos;
    }

    public void agregarTipoAparato(TipoAparato tA) {
        this.tiposAparatos.add(tA);
    }
    
    public void quitarTipoAparato(TipoAparato tA) {
        this.tiposAparatos.remove(tA);
    }
    
    @Override
    public String toString()
    {
        return this.getNombreHabitacion();
    }
}
