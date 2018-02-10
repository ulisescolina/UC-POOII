/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchouse;
import controlador.ControladorGeneral;
import modelo.*;
/**
 *
 * @author netbeans
 */
public class PCHouse {
    private static Usuario u;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorGeneral CG;
        
        /*Inicio de sesion*/
        if (Sesion.iniciarSesion("ulises", "12345")){
            System.out.println("Inicio sesion como '"+getUsuario()+"'");
        } else {
            System.err.println("No se pudo iniciar sesion.");
            return;
        }
        
        /*
          Dada la falta de un caso de uso para prueba del escenario en el documento
          integrador se brinda el siguiente ejemplo sencillo
        */
        
        CG = new ControladorGeneral(getUsuario()); 
        /*Aca se puede manejar algun tipo de temporizador para que la sesion
          caduque en un tiempo determinado*/
        
        System.out.println("Se demuestra que el usuario no tiene ningun edificio asociado");
        System.out.println("Edificios:" + getUsuario().getEdificios());
        System.out.println("");
        
        System.out.println("Se crea un edificio para el usuario");
        CG.crearEdificio("Edificio 1");
        System.out.println("Edificios:" + getUsuario().getEdificios());
        System.out.println("");
        
        System.out.println("Se crea otro edificio para el usuario");
        CG.crearEdificio("Edificio 2");
        System.out.println("Edificios:" + getUsuario().getEdificios());
        System.out.println("");
        
        Edificio e1 = (Edificio) getUsuario().getEdificios().toArray()[1];
        System.out.println("Se agrega una habitacion a '"+e1+"'");
        Habitacion h = new Habitacion("Habitacion nueva", e1);
        e1.agregarHabitacion(h);
        System.out.println("Vemos las habitaciones de "+e1+": " + e1.getHabitaciones());
        System.out.println("");
        
        System.out.println("Vemos cuales son los aparatos que posee '"+h+"': "+h.getTiposAparatos());
        System.out.println("Se agrega un aparato tipo LUZ y otro tipo AIRE ACONDICIONADO a '"+h+"'");
        CG.crearAparato("Lampara", "LUZ", h);
        CG.crearAparato("Aire Acondicionado", "AIRE ACONDICIONADO", h);
        System.out.println("Verificamos nuevamente los aparatos que posee '"+h+"': "+h.getTiposAparatos());
        System.out.println("");
        
        /*Instanciamos la Lampara*/
        TipoAparato ta1 = (TipoAparato) h.getTiposAparatos().toArray()[0];
        Luz l = (Luz) ta1;        

        /*Instanciamos el Aire Acondicionado*/
        TipoAparato ta2 = (TipoAparato) h.getTiposAparatos().toArray()[1];
        AireAcondicionado aa = (AireAcondicionado) ta2;
        
        System.out.println("Manipulamos el aparato '"+l+"' con los casos de uso");
        System.out.println("prenderAparato() y apagarAparato()");
        System.out.println("");
        System.out.println("Estado de "+ta1+": "+l.isEstado());
        System.out.println("Encendiendo "+l);
        CG.prenderAparato(ta1);
        System.out.println("Estado de "+ta1+": "+l.isEstado());
        System.out.println("Apagando "+l);
        CG.apagarAparato(l);
        System.out.println("Estado de "+ta1+": "+l.isEstado());
        System.out.println("");
        
        System.out.println("Manipulamos el aparato '"+aa+"' con los casos de uso");
        System.out.println("prenderAparato() y apagarAparato()");
        System.out.println("");
        System.out.println("Estado de "+ta2+": "+aa.isEstado());
        System.out.println("Encendiendo "+aa);
        CG.prenderAparato(ta2);
        System.out.println("Estado de "+ta2+": "+aa.isEstado());
        System.out.println("Apagando "+aa);
        CG.apagarAparato(aa);
        System.out.println("Estado de "+ta2+": "+aa.isEstado());
    }
    
    public static void setUsuario(Usuario usuario){
        PCHouse.u = usuario;
    }
    
    public static Usuario getUsuario()
    {
        return PCHouse.u;
    }
}
