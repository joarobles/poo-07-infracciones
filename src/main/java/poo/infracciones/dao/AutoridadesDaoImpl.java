/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.AutoridadConstatacion;

/**
 *
 * @author joaquinleonelrobles
 */
public class AutoridadesDaoImpl implements AutoridadesDao {
    
    private final SessionFactory sessionFactory;

    public AutoridadesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AutoridadConstatacion obtener(int legajo) {
        AutoridadConstatacion autoridad;
    
        try (Session session = sessionFactory.openSession()) {
             autoridad = session.get(AutoridadConstatacion.class, legajo);
        }
        
        return autoridad;
    }

    @Override
    public void guardar(AutoridadConstatacion autoridad) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(autoridad);
            session.getTransaction().commit();
        }
    }
    
}
