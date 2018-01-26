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
public class TipoDeRuta {
    
    private String nombre;
    private String descripcion;

    public TipoDeRuta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean esProvincial() {
        return false;
    }
    
    public boolean esNacional() {
        return false;
    }
    
    public boolean esInternacional() {
        return false;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
