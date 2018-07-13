/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.infracciones.modelos;

import java.math.BigDecimal;

/**
 *
 * @author joaquinleonelrobles
 */
public class TipoDeInfraccion {
    
    private Integer codigo;
    private String descripcion;
    private String observaciones;
    private BigDecimal importe;
    private int cantidadPuntosDescuento;
    private float porcentajeDescuento;

    public TipoDeInfraccion() {
    }

    public TipoDeInfraccion(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCantidadPuntosDescuento() {
        return cantidadPuntosDescuento;
    }

    public void setCantidadPuntosDescuento(int cantidadPuntosDescuento) {
        this.cantidadPuntosDescuento = cantidadPuntosDescuento;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    public boolean descuentaPuntos() {
        return false;
    }
    
    public boolean tieneDescuentoPorPagoVoluntario() {
        return false;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}
