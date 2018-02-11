/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchouse;

import modelo.*;
import controlador.*;

/**
 *
 * @author netbeans
 */
public class Sesion {
    
    protected static boolean iniciarSesion(String u, String c) 
    {
        /*Logica para trabajar con una base de datos va aca*/
        try {
            /*
              Reemplazar esto por logica que permita validar el usuario contra
              una base de datos de usuarios ya registrados y ahi recien 
              instanciarlo
            */
            PCHouse.setUsuario(new Usuario(u, c));
            return true;
        } catch (Exception e) {
            /*Error de validación de usuario*/
            return false;
        }
    }
}
