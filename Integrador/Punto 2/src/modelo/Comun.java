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
public class Comun extends Cuenta{
    private int costoPorPunto;
    
    
    public Comun(int id, int nCostoPorPunto) {
        super(id);
        this.costoPorPunto = nCostoPorPunto;
    }    

    public int getCostoPorPunto() {
        return costoPorPunto;
    }

    @Override
    public void agregarMovimiento(Movimiento nMovimiento)  {
        this.movimientos.add(nMovimiento);
    }
}
