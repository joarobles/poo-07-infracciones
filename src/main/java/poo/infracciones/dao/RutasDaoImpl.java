/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.Ruta;

/**
 *
 * @author joaquinleonelrobles
 */
public class RutasDaoImpl implements RutasDao {
    
    private final SessionFactory sessionFactory;

    public RutasDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Ruta obtener(int numero) {
        Ruta ruta;
    
        try (Session session = sessionFactory.openSession()) {
             ruta = session.get(Ruta.class, numero);
        }
        
        return ruta;
    }

    @Override
    public void guardar(Ruta ruta) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(ruta);
            session.getTransaction().commit();
        }
    }
    
}
