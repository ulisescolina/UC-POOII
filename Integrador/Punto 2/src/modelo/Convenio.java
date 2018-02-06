/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ulisss
 */
public class Convenio extends Cuenta{
    private Organizacion organizacion;
    
    public Convenio(int nId) {
        super(nId);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    @Override
    public void agregarMovimiento(Movimiento nMovimiento)  {
        this.movimientos.add(nMovimiento);
    }
    
    
}
