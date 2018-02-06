/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ulisss
 */
public class Sistema {
    private static Sistema s = null;
    private Map<Integer, Cuenta> cuentas;
    private List<Organizacion> organizaciones;
    
    private Sistema(){
        this.cuentas = new HashMap<>();
        this.organizaciones = new ArrayList<>();
        
        /*  Proceso para la creacion de los objetos necesarios para el */
        /*  funcionamiento del escenario */
        /**/int i;
        /**/Organizacion o;
        /**/for (i = 1; i <= 10; i++) {
        /**/    o = new Organizacion(i+2, 2); /*  instancio una nueva organizacion */
        /**/    this.organizaciones.add(o); /* agrego esta organizacion a las organizaciones que tiene el sistema  */
        /**/    if (i%2 == 0) { /* pongo esta condicion como para crear de las dos cosas cuentas de tipo comun y de tipo convenio*/
        /**/        
        /**/        Convenio c; 
        /**/        c = new Convenio(i); /* instancio una cuenta convenio */
        /**/        c.setOrganizacion(o); /* seteo la organizacion a la cual pertenece este convenio (debido a la bidireccionalidad de la relacion)*/
        /**/        o.agregarConvenio(c); /* agrego la cuenta al listado de cuentas que tiene la organizacion */
        /**/        
        /**/        this.cuentas.put(i, c); /* agrego la cuenta a las cuentas que tiene el sistema  */
        /**/    } else {
        /**/        Comun c;
        /**/        c = new Comun(i, 5); /* instancio una cuenta de tipo comun */
        /**/        this.cuentas.put(i, c); /* agrego la cuenta a las cuentas que tiene el sistema */
        /**/    }
        /**/}
        /*  Fin proceso */
    }
    
    /*Comportamiento Singleton*/
    public static Sistema getInstancia() {
        if (s == null) {
            s = new Sistema();
        }
        return s;
    }
    
    public int comprarPuntos(int idCuenta, int monto) {
        Cuenta cuentaAuxiliar;
        int puntos =0; int costoPorPuntos = 0;
        
        if (cuentas.containsKey(idCuenta)) { /*  Verifico si existe el id de la cuenta entre los objetos que tengo registrados  */
            cuentaAuxiliar = cuentas.get(idCuenta); /*  Obtengo la cuenta con el id en cuestion  */
            if (cuentaAuxiliar instanceof Convenio) { /*  Me pregunto si es una cuenta tipo convenio  */
                costoPorPuntos = ((Convenio) cuentaAuxiliar).getOrganizacion().getCostoPorPunto(); /*  Obtengo el costo por punto para una cuenta tipo convenio  */
                puntos = costoPorPuntos;
            } else if (cuentaAuxiliar instanceof Comun) {/*  Me pregunto si es una cuenta tipo comun  */
                costoPorPuntos = ((Comun) cuentaAuxiliar).getCostoPorPunto(); /*  Obtengo el costo por punto para una cuenta tipo comun  */
                puntos = monto/costoPorPuntos; /*  calculo para puntos que propone el ejercicio, tener en cuenta que el ejericio esta solicitando que se devuelva un entero, por eso puede que al realizace la division el resultado este redondeado  */
            }
            
            if (monto >= costoPorPuntos) { /* condicion de creacion de movimiento */
                Movimiento m = new Movimiento(puntos);  
                cuentaAuxiliar.agregarMovimiento(m); 
                return puntos;
            } else {
                System.err.print("Error. Movimiento no fue creado\n");
                return 0;
            }
        }
        System.err.print("Error. No se encuentra el id de la cuenta\n"); /*  si el id de cuenta no existe en los datos que tiene el sistema  */
        return 0;
    }
}
