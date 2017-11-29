/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class ArticuloCarrito extends ArticuloStock{
    /**
     * Precio total de los articulos; Cantidad de articulos por precio individual
     */
    private float precioTotal;

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }    
}
