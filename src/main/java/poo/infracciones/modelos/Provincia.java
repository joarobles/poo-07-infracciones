/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones;

import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class Provincia {
    
    private String nombre;
    private List<Localidad> localidades;

    public Provincia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }
    
    public Pais deQuePais(List<Pais> paises) {
        return null;
    }
    
    public boolean soyTuProvincia(Localidad localidad) {
        return false;
    }
    
    public int cuantasLocalidades() {
        return -1;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
