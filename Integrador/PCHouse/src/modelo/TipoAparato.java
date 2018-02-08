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
public abstract class TipoAparato {
    protected String nombreAparato;
    protected boolean estado;
    protected Habitacion habitacion;
    
    TipoAparato(String nA, Habitacion h) {
        this.nombreAparato = nA;
        this.estado = false;
        this.habitacion = h;
    }
    protected abstract void prender();
    protected abstract void apagar();
}
