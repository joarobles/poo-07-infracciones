/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author joaquinleonelrobles
 */
public class AutoridadConstatacion {
    
    private int legajo;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private int numeroDePlaca;
    private String sexo;

    public AutoridadConstatacion() {
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public int getNumeroDePlaca() {
        return numeroDePlaca;
    }

    public void setNumeroDePlaca(int numeroDePlaca) {
        this.numeroDePlaca = numeroDePlaca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int cuantasInfraccionesLabroEnPeriodo(List<ActaConstatacion> actas, LocalDate fechaDesde, LocalDate fechaHasta) {
        return -1;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
