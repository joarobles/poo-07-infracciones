/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import poo.infracciones.modelos.OrganismoEmisor;

/**
 *
 * @author joaquinleonelrobles
 */
public interface OrganismosEmisoresDao {
    
    OrganismoEmisor obtener(int id);
    
    void guardar(OrganismoEmisor emisor);
    
}
