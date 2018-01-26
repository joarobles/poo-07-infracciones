/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class Pais {
    
    private String nombre;
    private List<Provincia> provincias;

    public Pais() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    
    public int cuantasProvincias() {
        return -1;
    }
    
    public boolean soyTuPais(Provincia provincia) {
        return false;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
