/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class Modelo {
    
    private String nombre;

    public Modelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Marca queMarca(List<Marca> marca) {
        Marca retorno = null;
        
        Iterator<Marca> iter = marca.iterator();
        while (iter.hasNext()) {
            Marca actual = iter.next();
            
            if (actual.soyTuMarca(this)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
