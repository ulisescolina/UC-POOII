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
    private static ControladorGeneral cg = null;
    private Usuario u;
    
    /*Comportamiento Singleton*/
//    public static ControladorGeneral getCG(Usuario sesion) {
//        if (cg == null) {
//            cg = new ControladorGeneral(sesion);
//        }
//        return cg;
//    }
    
    public ControladorGeneral(Usuario sesion){
        this.u = sesion;
    }

    public void crearEdificio(String n)
    {
        Edificio e = new Edificio(n);
        e.agregarUsuario(this.u);
        u.agregarEdificio(e);
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
