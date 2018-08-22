/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import poo.infracciones.modelos.TipoDeInfraccion;

/**
 *
 * @author joaquinleonelrobles
 */
public interface TiposDeInfraccionDao {
    
    TipoDeInfraccion obtener(int id);
    
    void guardar(TipoDeInfraccion tipo);
    
}
