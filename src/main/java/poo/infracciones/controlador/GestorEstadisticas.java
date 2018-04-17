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
public class GestorEstadisticas {

    public GestorEstadisticas() {
    }
    
    public void run() {
        // obtenemos el conductor solicitado
        Conductor conductor = obtenerConductor();
        
        LocalDate fechaDesde = obtenerFechaDesde();
        LocalDate fechaHasta = obtenerFechaHasta();
        
        // TODO validar las fechas ingresadas
        
        // le preguntamos al conductor las estadísticas
        int cuantasInfraccionesEnPeriodo = conductor.cuantasInfraccionesEnPeriodo(fechaDesde, fechaHasta);
        BigDecimal totalImpagas = conductor.cuantoDebePorInfraccionesNoPagadas(fechaDesde, fechaHasta);
        
        // las mostramos en pantalla..
        mostrarResultados(cuantasInfraccionesEnPeriodo, totalImpagas);
    }
    
    public Conductor obtenerConductor() {
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
        
        Licencia vigente = new Licencia(LocalDate.of(2017, Month.DECEMBER, 1));
        
        // relación de asociación en ambas direcciones
        vigente.agregarActaConstatacion(acta1);
        acta1.setLicencia(vigente);
        
        vigente.agregarActaConstatacion(acta2);
        acta2.setLicencia(vigente);
        
        Licencia licenciaMoto = new Licencia(LocalDate.of(2017, Month.JULY, 1));
        
        Conductor federico = new Conductor("Federico", "Romano", "34070692", LocalDate.of(1989, Month.DECEMBER, 27), "Masculino");
        federico.agregarLicencia(vigente);
        federico.agregarLicencia(licenciaMoto);
        
        return federico;
    }
    
    public LocalDate obtenerFechaDesde() {
        return LocalDate.of(2016, Month.JANUARY, 1);
    }
    
    public LocalDate obtenerFechaHasta() {
        return LocalDate.now();
    }

    public void mostrarResultados(int cuantasInfraccionesEnPeriodo, BigDecimal totalImpagas) {
        System.out.println("Cantidad de infracciones: " + cuantasInfraccionesEnPeriodo);
        System.out.println("TOTAL de infracciones impagas: $" + totalImpagas);
    }
}
