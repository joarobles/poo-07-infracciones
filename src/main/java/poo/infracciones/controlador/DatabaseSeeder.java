/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.controlador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import poo.infracciones.dao.AutoridadesDao;
import poo.infracciones.dao.AutoridadesDaoImpl;
import poo.infracciones.dao.ConductoresDao;
import poo.infracciones.dao.ConductoresDaoImpl;
import poo.infracciones.dao.EstadosActasDao;
import poo.infracciones.dao.EstadosActasDaoImpl;
import poo.infracciones.dao.OrganismosEmisoresDao;
import poo.infracciones.dao.OrganismosEmisoresDaoImpl;
import poo.infracciones.dao.RutasDao;
import poo.infracciones.dao.RutasDaoImpl;
import poo.infracciones.dao.TiposDeInfraccionDao;
import poo.infracciones.dao.TiposDeInfraccionDaoImpl;
import poo.infracciones.dao.VehiculosDao;
import poo.infracciones.dao.VehiculosDaoImpl;
import poo.infracciones.modelos.ActaConstatacion;
import poo.infracciones.modelos.AutoridadConstatacion;
import poo.infracciones.modelos.Conductor;
import poo.infracciones.modelos.EstadoActa;
import poo.infracciones.modelos.Infraccion;
import poo.infracciones.modelos.Licencia;
import poo.infracciones.modelos.OrganismoEmisor;
import poo.infracciones.modelos.Ruta;
import poo.infracciones.modelos.TipoDeInfraccion;
import poo.infracciones.modelos.Vehiculo;

/**
 *
 * @author joaquinleonelrobles
 */
public class DatabaseSeeder {
    
    public static void main(String[] args) {
        // A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
			.build();
        
        SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	
        
        // creamos los objetos de capa de acceso a datos
        ConductoresDao conductoresDao = new ConductoresDaoImpl(sessionFactory);
        EstadosActasDao estadosDao = new EstadosActasDaoImpl(sessionFactory);
        OrganismosEmisoresDao emisoresDao = new OrganismosEmisoresDaoImpl(sessionFactory);
        VehiculosDao vehiculosDao = new VehiculosDaoImpl(sessionFactory);
        AutoridadesDao autoridadesDao = new AutoridadesDaoImpl(sessionFactory);
        RutasDao rutasDao = new RutasDaoImpl(sessionFactory);
        TiposDeInfraccionDao tiposDeInfraccionDao = new TiposDeInfraccionDaoImpl(sessionFactory);
        
        // obtenemos las entidades referenciadas
        OrganismoEmisor emisor = emisoresDao.obtener(1);
        Vehiculo onix = vehiculosDao.obtener("AB710ST");
        AutoridadConstatacion martinez = autoridadesDao.obtener(1234);
        Ruta ruta9 = rutasDao.obtener(9);
        
        // los estados los buscamos por nombre
        EstadoActa pagada = estadosDao.buscarPorNombre("Pagada");
        EstadoActa labrada = estadosDao.buscarPorNombre("Labrada");
        
        // creamos un nueva acta
        ActaConstatacion acta1 = new ActaConstatacion();
        acta1.setFechaHoraGeneracion(LocalDateTime.of(2017, Month.DECEMBER, 24, 15, 30, 27));
        acta1.setEstado(labrada);
        acta1.setObservaciones("Sin observaciones");
        acta1.setVehiculo(onix);
        acta1.setAutoridadConstatacion(martinez);
        acta1.setRuta(ruta9);
        
        ActaConstatacion acta2 = new ActaConstatacion();
        acta2.setFechaHoraGeneracion(LocalDateTime.of(2016, Month.APRIL, 11, 22, 50, 13));
        acta2.setEstado(pagada);
        acta2.setObservaciones("Sin observaciones");
        acta2.setVehiculo(onix);
        acta2.setAutoridadConstatacion(martinez);
        acta2.setRuta(ruta9);
       
        TipoDeInfraccion pasaEnDobleLinea = tiposDeInfraccionDao.obtener(1);
        TipoDeInfraccion lucesBajasApagadas = tiposDeInfraccionDao.obtener(2);
        
        Infraccion pasaEnDobleLineaRutaE53 = new Infraccion(pasaEnDobleLinea, new BigDecimal(2500), "Sin Observaciones");
        Infraccion lucesBajasApagadasRutaE53 = new Infraccion(lucesBajasApagadas, new BigDecimal(700), "No tenía repuesto");
        
        acta1.agregarInfraccion(pasaEnDobleLineaRutaE53);
        acta2.agregarInfraccion(lucesBajasApagadasRutaE53);
        
        Licencia vigente = new Licencia(1, LocalDate.of(2017, Month.DECEMBER, 1), LocalDate.of(2022, Month.DECEMBER, 1));
        vigente.setOrganismoEmisor(emisor);
        
        // relación de asociación en ambas direcciones
        vigente.agregarActaConstatacion(acta1);
        acta1.setLicencia(vigente);
        
        vigente.agregarActaConstatacion(acta2);
        acta2.setLicencia(vigente);
        
        Licencia licenciaMoto = new Licencia(2, LocalDate.of(2017, Month.JULY, 1), LocalDate.of(2022, Month.JULY, 1));
        licenciaMoto.setOrganismoEmisor(emisor);
        
        Conductor federico = new Conductor("Federico", "Romano", "34070692", LocalDate.of(1989, Month.DECEMBER, 27), "Masculino");
        federico.agregarLicencia(vigente);
        federico.agregarLicencia(licenciaMoto);
        
        conductoresDao.guardar(federico);
    }
}
