/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
/**
 *
 * @author netbeans
 */
public class ControladorGeneral {
    
    public ControladorGeneral(){
        
    }

    public void crearEdificio(String n, Usuario u)
    {
        Edificio e = new Edificio(n);
        e.agregarUsuario(u);
        Habitacion h = new Habitacion("Habitacion Inicial", e);
        e.agregarHabitacion(h);
    }
    
    public int crearAparato(String nombreAparato, String tipoAparato, Habitacion h)
    {
        if (h==null) {
            return 2; // Codigo de error 2
        }
        
        else if (tipoAparato==null) {
            return 1; // Codigo de error 1
        }
        
        switch (tipoAparato) {
            case "LUZ":
                        Luz l;
                        l = new Luz(nombreAparato, h);
                        h.agregarTipoAparato(l);
                        break;
            case "VENTILADOR":
                        Ventilador v;
                        v = new Ventilador(nombreAparato, h);
                        h.agregarTipoAparato(v);
                        break;
            case "AIRE ACONDICIONADO":
                        AireAcondicionado aa;
                        aa = new AireAcondicionado(nombreAparato, h);
                        h.agregarTipoAparato(aa);
                        break;
        }
        
        return 0; // Mensaje exitoso
    }
    
    public int prenderAparato(TipoAparato a)
    {
        if (a == null) {return 1;}
        
        if (a instanceof Luz) {
            Luz l = (Luz) a;
            if (!l.isEstado()) { // vemos si esta apagada la luz
                l.prender();
                return 0;
            }
        } else if (a instanceof Ventilador) {
            Ventilador v = (Ventilador) a;
            if (!v.isEstado()) { // vemos si esta apagado el ventilador
                v.prender();
                return 0;
            }
        } else if (a instanceof AireAcondicionado) {
            AireAcondicionado aa = (AireAcondicionado) a;
            if (!aa.isEstado()) { // vemos si esta apagado el aire acondicionado
                aa.prender();
                return 0;
            }
        }
        return 2; // error de instanciacion
    }
    
    public int apagarAparato(TipoAparato a)
    {
        
        if (a instanceof Luz) {
            Luz l = (Luz) a;
            if (l.isEstado()) { // vemos si esta encendida la luz
                l.apagar();
                return 0;
            }
        } else if (a instanceof Ventilador) {
            Ventilador v = (Ventilador) a;
            if (v.isEstado()) { // vemos si esta encendido el ventilador
                v.apagar();
                return 0;
            }
        } else if (a instanceof AireAcondicionado) {
            AireAcondicionado aa = (AireAcondicionado) a;
            if (aa.isEstado()) { // vemos si esta encendido el aire acondicionado
                aa.apagar();
                return 0;
            }
        }
        return 1;
    }
}
