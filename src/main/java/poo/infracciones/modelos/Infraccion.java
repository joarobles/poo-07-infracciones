/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones;

import java.math.BigDecimal;

/**
 *
 * @author joaquinleonelrobles
 */
public class Infraccion {
    
    private TipoDeInfraccion tipo;
    private BigDecimal monto;
    private String observacion;

    public Infraccion() {
    }

    public Infraccion(TipoDeInfraccion tipo, BigDecimal monto, String observacion) {
        this.tipo = tipo;
        this.monto = monto;
        this.observacion = observacion;
    }

    public TipoDeInfraccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeInfraccion tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public BigDecimal calcularMontoConDescuento() {
        return null;
    }
    
    public String obtenerDescripcion() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
