/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class ActaConstatacion {
    
    private int numero;
    private Vehiculo vehiculo;
    private Licencia licencia;
    private LocalDateTime fechaHoraGeneracion;
    private String lugarDeConstatacion;
    private Ruta ruta;
    private AutoridadConstatacion autoridadConstatacion;
    private LocalDate fechaVencimientoPagoVoluntario;
    private String observaciones;
    private EstadoActa estado;
    private List<Infraccion> infracciones;

    public ActaConstatacion() {
        this.infracciones = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public LocalDateTime getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public void setFechaHoraGeneracion(LocalDateTime fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public String getLugarDeConstatacion() {
        return lugarDeConstatacion;
    }

    public void setLugarDeConstatacion(String lugarDeConstatacion) {
        this.lugarDeConstatacion = lugarDeConstatacion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public AutoridadConstatacion getAutoridadConstatacion() {
        return autoridadConstatacion;
    }

    public void setAutoridadConstatacion(AutoridadConstatacion autoridadConstatacion) {
        this.autoridadConstatacion = autoridadConstatacion;
    }

    public LocalDate getFechaVencimientoPagoVoluntario() {
        return fechaVencimientoPagoVoluntario;
    }

    public void setFechaVencimientoPagoVoluntario(LocalDate fechaVencimientoPagoVoluntario) {
        this.fechaVencimientoPagoVoluntario = fechaVencimientoPagoVoluntario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoActa getEstado() {
        return estado;
    }

    public void setEstado(EstadoActa estado) {
        this.estado = estado;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }
    
    public BigDecimal calcularMontoTotalInfracciones() {
        return null;
    }
    
    public int cuantasInfraccionesContiene() {
        return this.infracciones.size();
    }
    
    public boolean estaEnFechaDePagoVoluntario() {
        return false;
    }
    
    public List<TipoDeInfraccion> queInfraccionesContiene() {
        return null;
    }

    public void agregarInfraccion(Infraccion infraccion) {
        this.infracciones.add(infraccion);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
