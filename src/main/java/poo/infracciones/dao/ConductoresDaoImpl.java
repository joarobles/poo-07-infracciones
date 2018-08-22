/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public Conductor buscarPorDni(String dni) {
        Conductor conductor;
        
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Conductor> query = builder.createQuery(Conductor.class);
            
            Root<Conductor> root = query.from(Conductor.class);
            query.select(root);
            query.where(builder.equal(root.get("dni"), dni));
            
            conductor = session.createQuery(query).uniqueResult();
        }
        
        return conductor;
    }
    
}
