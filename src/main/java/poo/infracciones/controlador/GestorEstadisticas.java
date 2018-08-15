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
import poo.infracciones.ui.PantallaGenerarReporteInfracciones;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorEstadisticas {
    
    private final PantallaGenerarReporteInfracciones pantalla;
    private final ConductoresDao conductoresDao;
    
    private Conductor conductor;

    public GestorEstadisticas(ConductoresDao conductoresDao) {
        this.conductoresDao = conductoresDao;
        this.pantalla = new PantallaGenerarReporteInfracciones(this);
    }
    
    public void run() {
        // mostramos la pantalla
        pantalla.setVisible(true);
    }
    
    public void tomarDniConductor(String dni) {
        conductor = conductoresDao.buscarPorDni(dni);
        
        // si hemos encontrado un conductor para ese DNI
        if (conductor != null) {
            pantalla.mostrarConductor(conductor);
        }
        else {
            // de lo contrario mostramos un mensaje de error
        }
    }

    public void tomarFechasPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        // mostramos la cantidad de infracciones
        pantalla.mostrarCantidadInfracciones(conductor.cuantasInfraccionesEnPeriodo(fechaDesde, fechaHasta));
        
        // mostramos el monto total adeudado
        pantalla.mostrarMontoAdeudado(conductor.cuantoDebePorInfraccionesNoPagadas(fechaDesde, fechaHasta));
    }
}
