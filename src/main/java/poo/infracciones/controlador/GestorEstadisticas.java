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
import poo.infracciones.ActaConstatacion;
import poo.infracciones.Conductor;
import poo.infracciones.Infraccion;
import poo.infracciones.Licencia;
import poo.infracciones.TipoDeInfraccion;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorEstadisticas {

    public GestorEstadisticas() {
    }
    
    public void run () {
        
        ActaConstatacion acta1 = new ActaConstatacion();
        acta1.setFechaHoraGeneracion(LocalDateTime.of(2017, Month.DECEMBER, 24, 15, 30, 27));
        
        ActaConstatacion acta2 = new ActaConstatacion();
        acta2.setFechaHoraGeneracion(LocalDateTime.of(2016, Month.APRIL, 11, 22, 50, 13));
       
        TipoDeInfraccion pasaEnDobleLinea = new TipoDeInfraccion(1, "Adelantar en doble línea amarilla");
        TipoDeInfraccion lucesBajasApagadas = new TipoDeInfraccion(2, "Luces bajas apagadas en ruta");
        
        Infraccion pasaEnDobleLineaRutaE53 = new Infraccion(pasaEnDobleLinea, new BigDecimal(2500), "Sin Observaciones");
        Infraccion lucesBajasApagadasRutaE53 = new Infraccion(lucesBajasApagadas, new BigDecimal(700), "No tenía repuesto");
        
        acta1.agregarInfraccion(pasaEnDobleLineaRutaE53);
        acta2.agregarInfraccion(lucesBajasApagadasRutaE53);
        
        Licencia vigente = new Licencia();
        
        // relación de asociación en ambas direcciones
        vigente.agregarActaConstatacion(acta1);
        acta1.setLicencia(vigente);
        
        vigente.agregarActaConstatacion(acta2);
        acta2.setLicencia(vigente);
        
        Licencia licenciaMoto = new Licencia();
        
        Conductor federico = new Conductor("Federico", "Romano", "34070692", LocalDate.of(1989, Month.DECEMBER, 27), "Masculino");
        federico.agregarLicencia(vigente);
        federico.agregarLicencia(licenciaMoto);
        
        // mostramos la cantidad de infracciones en un periodo
        LocalDate desde = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate hasta = LocalDate.now();
        
        // le preguntamos al conductor
        int cuantasEnPeriodo = federico.cuantasInfraccionesEnPeriodo(desde, hasta);
        
        System.out.println("Cantidad de infracciones: " + cuantasEnPeriodo);
    }
}
