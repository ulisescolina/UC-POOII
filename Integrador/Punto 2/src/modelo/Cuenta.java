/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ulisss
 */
public abstract class Cuenta {
    public int id;
    public List<Movimiento> movimientos;
    
    
    public Cuenta (int nId) {
        this.id = nId;
        this.movimientos = new ArrayList<>();
    }

    public abstract void agregarMovimiento (Movimiento nMovimiento);
}
