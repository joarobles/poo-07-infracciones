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
    
    private int codigo;
    private String descripcion;
    private String observacion;
    private BigDecimal importe;
    private int cantidadPuntosDescuento;
    private float porcentajeDescuento;

    public TipoDeInfraccion() {
    }

    public TipoDeInfraccion(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        return "TipoDeInfraccion{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", observacion=" + observacion + ", importe=" + importe + ", cantidadPuntosDescuento=" + cantidadPuntosDescuento + ", porcentajeDescuento=" + porcentajeDescuento + '}';
    }
    
}
