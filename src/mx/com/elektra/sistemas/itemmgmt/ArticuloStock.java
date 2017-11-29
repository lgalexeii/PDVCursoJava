/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

import java.util.Objects;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class ArticuloStock {
    private Articulo articulo;
    private int cantidad;
    
    public ArticuloStock(){}
    
    public ArticuloStock(Articulo articulo, int cantidad){
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   

    @Override
    public String toString() {
        return cantidad +"\t"+ articulo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.articulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticuloStock other = (ArticuloStock) obj;
        return this.articulo.equals(other.articulo) ;
    }

    void validarExistencias(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
