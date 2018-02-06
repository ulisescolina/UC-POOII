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
public class Organizacion {
    private int id;
    private int costoPorPunto;
    private List<Convenio> convenios;
    
    public Organizacion(int id, int nCostoPorPunto) {
        this.id = id;
        this.costoPorPunto = nCostoPorPunto;
        this.convenios = new ArrayList<>();
    }

    public int getCostoPorPunto() {
        return costoPorPunto;
    }
    
    public void agregarConvenio(Convenio c) {
        convenios.add(c);
    }
}
