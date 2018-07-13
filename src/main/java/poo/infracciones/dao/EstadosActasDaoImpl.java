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
import poo.infracciones.modelos.EstadoActa;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosActasDaoImpl implements EstadosActasDao {
    
    private final SessionFactory sessionFactory;

    public EstadosActasDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EstadoActa buscarPorNombre(String nombre) {
        EstadoActa estado;
        
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<EstadoActa> query = builder.createQuery(EstadoActa.class);
            
            Root<EstadoActa> root = query.from(EstadoActa.class);
            query.select(root);
            query.where(builder.equal(root.get("nombre"), nombre));
            
            estado = session.createQuery(query).uniqueResult();
        }
        
        return estado;
    }
    
}
