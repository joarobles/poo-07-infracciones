/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import poo.infracciones.modelos.Ruta;

/**
 *
 * @author joaquinleonelrobles
 */
public interface RutasDao {
    
    Ruta obtener(int numero);
    
    void guardar(Ruta ruta);
    
}
