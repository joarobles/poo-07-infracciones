/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.controlador;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import poo.infracciones.dao.ConductoresDao;
import poo.infracciones.dao.ConductoresDaoImpl;
import poo.infracciones.modelos.Conductor;
import poo.infracciones.ui.PantallaGenerarReporteInfracciones;

/**
 *
 * @author joaquinleonelrobles
 */
public class GestorEstadisticas {
    
    private final SessionFactory sessionFactory;
    
    private final PantallaGenerarReporteInfracciones pantalla;
    private final ConductoresDao conductoresDao;
    
    private Conductor conductor;

    public GestorEstadisticas(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.conductoresDao = new ConductoresDaoImpl(sessionFactory);
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
    
    public void imprimirReporte(LocalDate fechaDesde, LocalDate fechaHasta) {
        // abrimos una sesion de hibernate
        Session session = sessionFactory.openSession();

        // utilizamos la sesion de hibernate para acceder a la conexion JDBC
        session.doWork(new Work() {
            @Override
            public void execute(Connection conexion) throws SQLException {
                try {
                    // armamos el modelo de parametros
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("ID_CONDUCTOR", conductor.getId());
                    parametros.put("FECHA_DESDE", Date.from(fechaDesde.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    parametros.put("FECHA_HASTA", Date.from(fechaHasta.atStartOfDay(ZoneId.systemDefault()).toInstant()));

                    // creamos el reporte
                    InputStream design = getClass().getResourceAsStream("/reportes/infracciones-cometidas-monto-adeudado.jasper");
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(design);

                    // imprimimos el reporte con los parametros
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);

                    // visualizamos el reporte en pantalla
                    JasperViewer.viewReport(jasperPrint, false);
                }
                catch (JRException ex) {
                    System.out.println("Error al generar el reporte: " + ex.getMessage());
                }
            }
        });

        // cerramos la sesion
        session.close();
    }
}
