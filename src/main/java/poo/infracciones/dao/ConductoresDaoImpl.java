/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.Conductor;

/**
 *
 * @author joaquinleonelrobles
 */
public class ConductoresDaoImpl implements ConductoresDao {
    
    private final SessionFactory sessionFactory;

    public ConductoresDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Conductor obtener(int id) {
        Conductor conductor;
    
        try (Session session = sessionFactory.openSession()) {
             conductor = session.get(Conductor.class, id);
        }
        
        return conductor;
    }

    @Override
    public void guardar(Conductor conductor) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(conductor);
            session.getTransaction().commit();
        }
    }
    
}
