/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class Carrito {
    private List<ArticuloCarrito> listaCompras;
    
    public Carrito(){
        listaCompras = new ArrayList<>();
    }
    
    public void agregarArticulo(Articulo articulo, int cantidad){
        
        ArticuloCarrito art = Tienda.obtenerArticulo(articulo,cantidad);
        listaCompras.add(art);
    }    
}
