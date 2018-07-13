/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.controlador;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import poo.infracciones.dao.ConductoresDao;
import poo.infracciones.dao.ConductoresDaoImpl;

/**
 *
 * @author joaquinleonelrobles
 */
public class Main {
    
    public static void main(String[] args) {
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
        
        SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	ConductoresDao dao = new ConductoresDaoImpl(sessionFactory);
            
        new GestorEstadisticas(dao).run();
        
    }
}
