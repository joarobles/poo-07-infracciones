/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones;

/**
 *
 * @author joaquinleonelrobles
 */
public class Ruta {
    
    private String nombre;
    private int numero;
    private TipoDeRuta tipoRuta;

    public Ruta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoDeRuta getTipoRuta() {
        return tipoRuta;
    }

    public void setTipoRuta(TipoDeRuta tipoRuta) {
        this.tipoRuta = tipoRuta;
    }
    
    public boolean esRutaProvincial() {
        return false;
    }
    
    public boolean esRutaNacional() {
        return false;
    }
    
    public boolean esRutaInternacional() {
        return false;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
