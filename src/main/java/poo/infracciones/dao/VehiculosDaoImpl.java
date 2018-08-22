/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.infracciones.modelos.Conductor;
import poo.infracciones.modelos.Vehiculo;

/**
 *
 * @author joaquinleonelrobles
 */
public class VehiculosDaoImpl implements VehiculosDao {

    private final SessionFactory sessionFactory;

    public VehiculosDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Vehiculo obtener(String dominio) {
        Vehiculo vehiculo;
    
        try (Session session = sessionFactory.openSession()) {
             vehiculo = session.get(Vehiculo.class, dominio);
        }
        
        return vehiculo;
    }

    @Override
    public void guardar(Vehiculo vehiculo) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(vehiculo);
            session.getTransaction().commit();
        }
    }
    
}
