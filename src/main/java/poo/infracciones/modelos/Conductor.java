/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class Conductor {
    
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String sexo;
    private List<Licencia> licencias;

    public Conductor() {
    }

    public Conductor(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.licencias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }
    
    public void agregarLicencia(Licencia licencia) {
        this.licencias.add(licencia);
    }
    
    public int cuantasActasEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return -1;
    }
    
    public int cuantasInfraccionesEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        int infracciones = 0;
        
        // iteramos sobre las licencias del conductor
        Iterator<Licencia> iter = licencias.iterator();
        while (iter.hasNext()) {
            // acumulamos las infracciones de esta licencia
            infracciones += iter.next().cuantasInfraccionesEnPeriodo(fechaDesde, fechaHasta);
        }
        
        return infracciones;
    }
    
    public BigDecimal cuantoDebePorInfraccionesNoPagadas(LocalDate fechaDesde, LocalDate fechaHasta) {
        BigDecimal total = BigDecimal.ZERO;
        
        // iteramos sobre las licencias del conductor
        Iterator<Licencia> iter = licencias.iterator();
        while (iter.hasNext()) {
            // acumulamos los montos de actas no pagadas
            total = total.add(iter.next().cuantoDebePorInfraccionesNoPagadas(fechaDesde, fechaHasta));
        }
        
        return total;
    }
    
    public List<Infraccion> obtenerInfraccionesEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
