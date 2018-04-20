/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author joaquinleonelrobles
 */
public class LicenciaTest {
    
    private Licencia licencia;
    
    @Before
    public void setUp() {
        this.licencia = new Licencia(1, LocalDate.of(2017, Month.DECEMBER, 1), LocalDate.of(2022, Month.DECEMBER, 1));
    }
    
    @Test
    public void probarOtorgadaEntreFechas() {
        LocalDate desde = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate hasta = LocalDate.of(2018, Month.JANUARY, 1);
        
        assertTrue(licencia.estasEnPeriodo(desde, hasta));
    }
    
    @Test
    public void probarVencidaEntreFechas() {
        LocalDate desde = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate hasta = LocalDate.of(2023, Month.JANUARY, 1);
        
        assertTrue(licencia.estasEnPeriodo(desde, hasta));
    }
    
    @Test
    public void probarOtorgadaVencidaEntreFechas() {
        LocalDate desde = LocalDate.of(2017, Month.DECEMBER, 2);
        LocalDate hasta = LocalDate.of(2022, Month.NOVEMBER, 30);
        
        assertTrue(licencia.estasEnPeriodo(desde, hasta));
    }
    
    @Test
    public void probarVencidaAntes() {
        LocalDate desde = LocalDate.of(2022, Month.DECEMBER, 2);
        LocalDate hasta = LocalDate.of(2023, Month.JANUARY, 1);
        
        assertFalse(licencia.estasEnPeriodo(desde, hasta));
    }
    
    @Test
    public void probarOtorgadaDespues() {
        LocalDate desde = LocalDate.of(2016, Month.DECEMBER, 2);
        LocalDate hasta = LocalDate.of(2017, Month.NOVEMBER, 30);
        
        assertFalse(licencia.estasEnPeriodo(desde, hasta));
    }
}
