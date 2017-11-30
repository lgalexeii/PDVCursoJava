/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

import java.text.NumberFormat;
import java.util.Objects;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class Articulo {
    private String sku;
    private String descripcion;
    private float precio;
    private float descuento;
    
    public Articulo(String sku,String descripcion,float precio,float descuento){
        this.sku = sku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Articulo(String sku) {
       this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    private String formatDiscount(){
        return (descuento * 100) + "%";
    }
    
    private String formatPrice(){
        NumberFormat format =  NumberFormat.getNumberInstance();
        return  format.format(precio);
    }

    @Override
    public String toString() {
        return sku + " \t " + descripcion + " \t " + formatPrice() + " \t " + formatDiscount() ;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Articulo))
            return false;
        return this.sku.equals(((Articulo)obj).getSku());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.sku);
        return hash;
    }
    
    
    
}
