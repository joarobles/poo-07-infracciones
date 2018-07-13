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
    
    private final ConductoresDao conductoresDao;

    public GestorEstadisticas(ConductoresDao conductoresDao) {
        this.conductoresDao = conductoresDao;
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
        Conductor federico = conductoresDao.obtener(1);
        
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
