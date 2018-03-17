/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import modelo.*;
/**
 *
 * @author netbeans
 */
public class ControladorGeneral {
    private static ControladorGeneral cg = null;
    private Usuario u;
    
    /*Comportamiento Singleton*/
    public static ControladorGeneral getCG(Usuario sesion) {
        if (cg == null) {
            cg = new ControladorGeneral(sesion);
        }
        return cg;
    }
    
    public ControladorGeneral(Usuario sesion){
        this.u = sesion;
    }

    public void crearEdificio(String n)
    {
        ArrayList<Edificio> edificiosUsuario = u.getEdificios();
        Iterator<Edificio> itr = edificiosUsuario.iterator();
     
        if (n == null) {
            System.err.println("Se debe proveer de un nombre para el edificio a crear");
            return;
        }
        
        while (itr.hasNext()) {
            Edificio edificioUsuario = itr.next();
            if (edificioUsuario.getNombreEdificio().equals(n)) {
                System.err.println("El usuario "+this.u.getUsuario()+" ya posee un edificio denominado \""+n+"\"");
                return;
            }
        }
        
        Edificio e = new Edificio(n);
        e.agregarUsuario(this.u);
        u.agregarEdificio(e);
        Habitacion h = new Habitacion("Habitacion Inicial", e);
        e.agregarHabitacion(h);
        System.out.println("Edificio '"+n+"' creado satisfactoriamente");
    }
    
    public int crearAparato(String nombreAparato, String tipoAparato, Habitacion h)
    {
        ArrayList<TipoAparato> aparatosEnHabitacion = h.getTiposAparatos();
        Iterator<TipoAparato> itr = aparatosEnHabitacion.iterator();
        
        while (itr.hasNext()) {
            TipoAparato aparato = itr.next();
            if (aparato instanceof Luz) {/*Si es luz*/
                Luz l = (Luz) aparato;
                if (l.getNombreAparato().equals(nombreAparato)) {
                    System.err.println("La habitacion "+h.getNombreHabitacion()+" ya posee un aparato denominado \""+l.getNombreAparato()+"\"");
                    return 1;
                }
            } else if (aparato instanceof Ventilador) {/*Si es ventilador*/
                Ventilador v = (Ventilador) aparato;
                if (v.getNombreAparato().equals(nombreAparato)) {
                    System.err.println("La habitacion "+h.getNombreHabitacion()+" ya posee un aparato denominado \""+v.getNombreAparato()+"\"");
                    return 1;
                }
            } else if (aparato instanceof AireAcondicionado) { /*Si es aire acondicionado*/
                AireAcondicionado aa = (AireAcondicionado) aparato;
                if (aa.getNombreAparato().equals(nombreAparato)) {
                    System.err.println("La habitacion "+h.getNombreHabitacion()+" ya posee un aparato denominado \""+aa.getNombreAparato()+"\"");
                    return 1;
                }
            } else {
                System.err.println("Este tipo de aparato aun no tiene soporte en el sistema.");
                return 1;
            }
        }
        
        if (h==null) {
            System.err.println("Debe proveer la habitacion en la cual sera creada el aparato.");
            return 1;
        }
        
        else if (tipoAparato==null) {
            System.err.println("Debe proveer el tipo de aparato a crear.");
            return 1;
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
            default:
                        System.err.println("Este tipo de aparato aun no tiene soporte en el sistema.");
                        return 1;
        }
        
        return 0; // Mensaje exitoso
    }
    
    public int prenderAparato(TipoAparato a)
    {
        if (a == null) {
            System.out.println("Se debe brindar el aparato a ser prendido.");
            return 1;
        }
        
        if (a instanceof Luz) {
            Luz l = (Luz) a;
            if (!l.isEstado()) { // vemos si esta apagada la luz
                l.prender();
                System.out.println("El aparato se encuentra encendido.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra encendido.");
                return 1;
            }
        } else if (a instanceof Ventilador) {
            Ventilador v = (Ventilador) a;
            if (!v.isEstado()) { // vemos si esta apagado el ventilador'
                v.prender();
                System.out.println("El aparato se encuentra encendido.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra encendido.");
                return 1;
            }
        } else if (a instanceof AireAcondicionado) {
            AireAcondicionado aa = (AireAcondicionado) a;
            if (!aa.isEstado()) { // vemos si esta apagado el aire acondicionado
                aa.prender();
                System.out.println("El aparato se encuentra encendido.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra encendido.");
                return 1;
            }
        }
        return 2;
    }
    
    public int apagarAparato(TipoAparato a)
    {
        if (a==null) {
            System.out.println("Se debe brindar el aparato a ser apagado.");
            return 1;
        }
        if (a instanceof Luz) {
            Luz l = (Luz) a;
            if (l.isEstado()) { // vemos si esta encendida la luz
                l.apagar();
                System.out.println("El aparato se encuentra apagado.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra apagado.");
                return 1;
            }
        } else if (a instanceof Ventilador) {
            Ventilador v = (Ventilador) a;
            if (v.isEstado()) { // vemos si esta encendido el ventilador
                v.apagar();
                System.out.println("El aparato se encuentra apagado.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra apagado.");
                return 1;
            }
        } else if (a instanceof AireAcondicionado) {
            AireAcondicionado aa = (AireAcondicionado) a;
            if (aa.isEstado()) { // vemos si esta encendido el aire acondicionado
                aa.apagar();
                System.out.println("El aparato se encuentra apagado.");
                return 0;
            } else {
                System.out.println("El aparato ya se encuentra apagado.");
                return 1;
            }
        }
        return 2;
    }
    
    @Override
    public String toString()
    {
        return u.getUsuario();
    }
}
