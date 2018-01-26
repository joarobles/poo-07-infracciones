/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

/**
 *
 * @author joaquinleonelrobles
 */
public class OrganismoEmisor {
    
    private String nombre;
    private Localidad localidad;

    public OrganismoEmisor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
