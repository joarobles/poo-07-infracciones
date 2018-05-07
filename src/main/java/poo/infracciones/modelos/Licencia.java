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
public class Licencia {
    
    private int numero;
    private LocalDate fechaOtorgamiento;
    private LocalDate fechaVencimiento;
    private OrganismoEmisor organismoEmisor;
    private List<ActaConstatacion> actas;

    public Licencia() {
        this.actas = new ArrayList<>();
    }

    public Licencia(int numero, LocalDate fechaOtorgamiento, LocalDate fechaVencimiento) {
        this.numero = numero;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.fechaVencimiento = fechaVencimiento;
        this.actas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(LocalDate fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public OrganismoEmisor getOrganismoEmisor() {
        return organismoEmisor;
    }

    public void setOrganismoEmisor(OrganismoEmisor organismoEmisor) {
        this.organismoEmisor = organismoEmisor;
    }

    public List<ActaConstatacion> getActas() {
        return actas;
    }

    public void setActas(List<ActaConstatacion> actas) {
        this.actas = actas;
    }
    
    public void agregarActaConstatacion(ActaConstatacion acta) {
        this.actas.add(acta);
    }
    
    /**
     * Devuelve la cantidad de infracciones cometidas en un periodo de tiempo
     * determinado
     * 
     * @param fechaDesde fecha de inicio de la consulta
     * @param fechaHasta fecha de fin de la consulta
     * @return Cantidad de infracciones cometidas
     */
    public int cuantasInfraccionesEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return -1;
    }

    public BigDecimal cuantoDebePorInfraccionesNoPagadas(LocalDate fechaDesde, LocalDate fechaHasta) {
        return null;
    }

    public boolean estasEnPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) {
        return false;
    }
}
