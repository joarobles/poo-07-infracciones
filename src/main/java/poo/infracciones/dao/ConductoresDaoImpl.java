/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.infracciones.modelos.Conductor;

/**
 *
 * @author joaquinleonelrobles
 */
public class ConductoresDaoImpl implements ConductoresDao {
    
    private final List<Conductor> conductores;

    public ConductoresDaoImpl() {
        this.conductores = new ArrayList<>();
    }

    @Override
    public Conductor obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Conductor conductor) {
        conductores.add(conductor);
    }

    @Override
    public Conductor buscarPorDni(String dni) {
        Conductor retorno = null;
        
        Iterator<Conductor> iter = conductores.iterator();
        while (iter.hasNext()) {
            Conductor c = iter.next();
            
            if (c.getDni().equals(dni)) {
                retorno = c;
                break;
            }
        }
        
        return retorno;
    }
    
}
