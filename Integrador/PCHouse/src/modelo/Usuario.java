/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author netbeans
 */
public class Usuario {
    private String usuario;
    private String contrasenia;
    
    /*Relacion con edificios*/
    private ArrayList<Edificio> edificios = new ArrayList<>();
    
    public Usuario(String u, String c) {
        this.usuario = u;
        this.contrasenia = c;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public void agregarEdificio(Edificio e) {
        this.edificios.add(e);
    }
    
    public void quitarEdificio(Edificio e) {
        this.edificios.remove(e);
    }
}
