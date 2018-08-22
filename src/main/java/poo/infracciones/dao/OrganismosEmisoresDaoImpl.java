/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.OrganismoEmisor;

/**
 *
 * @author joaquinleonelrobles
 */
public class OrganismosEmisoresDaoImpl implements OrganismosEmisoresDao {
    
    private final SessionFactory sessionFactory;

    public OrganismosEmisoresDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public OrganismoEmisor obtener(int id) {
        OrganismoEmisor emisor;
    
        try (Session session = sessionFactory.openSession()) {
             emisor = session.get(OrganismoEmisor.class, id);
        }
        
        return emisor;
    }

    @Override
    public void guardar(OrganismoEmisor emisor) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(emisor);
            session.getTransaction().commit();
        }
    }
    
    
    
}
