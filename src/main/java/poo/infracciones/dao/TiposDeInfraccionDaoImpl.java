/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.Ruta;
import poo.infracciones.modelos.TipoDeInfraccion;

/**
 *
 * @author joaquinleonelrobles
 */
public class TiposDeInfraccionDaoImpl implements TiposDeInfraccionDao {
    
    private final SessionFactory sessionFactory;

    public TiposDeInfraccionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TipoDeInfraccion obtener(int id) {
        TipoDeInfraccion tipo;
    
        try (Session session = sessionFactory.openSession()) {
             tipo = session.get(TipoDeInfraccion.class, id);
        }
        
        return tipo;
    }

    @Override
    public void guardar(TipoDeInfraccion tipo) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(tipo);
            session.getTransaction().commit();
        }
    }
    
}
