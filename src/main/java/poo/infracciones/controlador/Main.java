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
import poo.infracciones.dao.ConductoresDao;
import poo.infracciones.dao.ConductoresDaoImpl;
import poo.infracciones.modelos.ActaConstatacion;
import poo.infracciones.modelos.Conductor;
import poo.infracciones.modelos.EstadoActa;
import poo.infracciones.modelos.Infraccion;
import poo.infracciones.modelos.Licencia;
import poo.infracciones.modelos.TipoDeInfraccion;

/**
 *
 * @author joaquinleonelrobles
 */
public class Main {
    
    public static void main(String[] args) {
        EstadoActa pagada = new EstadoActa("Pagada");
        EstadoActa labrada = new EstadoActa("Labrada");
        
        ActaConstatacion acta1 = new ActaConstatacion();
        acta1.setFechaHoraGeneracion(LocalDateTime.of(2017, Month.DECEMBER, 24, 15, 30, 27));
        acta1.setEstado(labrada);
        
        ActaConstatacion acta2 = new ActaConstatacion();
        acta2.setFechaHoraGeneracion(LocalDateTime.of(2016, Month.APRIL, 11, 22, 50, 13));
        acta2.setEstado(pagada);
       
        TipoDeInfraccion pasaEnDobleLinea = new TipoDeInfraccion(1, "Adelantar en doble línea amarilla");
        TipoDeInfraccion lucesBajasApagadas = new TipoDeInfraccion(2, "Luces bajas apagadas en ruta");
        
        Infraccion pasaEnDobleLineaRutaE53 = new Infraccion(pasaEnDobleLinea, new BigDecimal(2500), "Sin Observaciones");
        Infraccion lucesBajasApagadasRutaE53 = new Infraccion(lucesBajasApagadas, new BigDecimal(700), "No tenía repuesto");
        
        acta1.agregarInfraccion(pasaEnDobleLineaRutaE53);
        acta2.agregarInfraccion(lucesBajasApagadasRutaE53);
        
        Licencia vigente = new Licencia(1, LocalDate.of(2017, Month.DECEMBER, 1), LocalDate.of(2022, Month.DECEMBER, 1));
        
        // relación de asociación en ambas direcciones
        vigente.agregarActaConstatacion(acta1);
        acta1.setLicencia(vigente);
        
        vigente.agregarActaConstatacion(acta2);
        acta2.setLicencia(vigente);
        
        Licencia licenciaMoto = new Licencia(2, LocalDate.of(2017, Month.JULY, 1), LocalDate.of(2022, Month.JULY, 1));
        
        Conductor federico = new Conductor("Federico", "Romano", "34070692", LocalDate.of(1989, Month.DECEMBER, 27), "Masculino");
        federico.agregarLicencia(vigente);
        federico.agregarLicencia(licenciaMoto);
        
        // llenamos los datos en la capa DAO
        ConductoresDao conductoresDao = new ConductoresDaoImpl();
        conductoresDao.guardar(federico);
        
        new GestorEstadisticas(conductoresDao).run();
    }
}
