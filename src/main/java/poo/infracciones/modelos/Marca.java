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
public class Marca {

    private String nombre;
    private List<Modelo> modelos;

    public Marca() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    public boolean soyTuMarca(Modelo modelo) {
        return modelos.contains(modelo);
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
