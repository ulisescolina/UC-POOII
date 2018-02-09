/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author netbeans
 */
public class AireAcondicionado extends TipoAparato {
    private double temperatura;
    
    public AireAcondicionado (String nA, Habitacion h) {
        super(nA, h);
        this.temperatura = 24.0;
    }
    
    @Override
    public void prender() {
        this.estado = true;
    }
    
    @Override
    public void apagar() {
        this.estado = false;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getNombreAparato() {
        return nombreAparato;
    }

    public void setNombreAparato(String nombreAparato) {
        this.nombreAparato = nombreAparato;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    @Override
    public String toString()
    {
        return this.getNombreAparato();
    }
}
