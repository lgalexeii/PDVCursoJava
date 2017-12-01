/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

import mx.com.elektra.sistemas.busmgmt.Tienda;
import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.sistemas.exceptions.ArticuloNoEncontradoException;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class Carrito {
    private List<ArticuloCompra> listaCompras;
    
    public Carrito(){
        listaCompras = new ArrayList<>();
    }
    
    public void agregarArticulo(String articulo, int cantidad){
        try{
            ArticuloCompra art = Tienda.obtenerArticulo(articulo,cantidad);
            listaCompras.add(art);
        }catch(ArticuloNoEncontradoException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrito de Compras: " + "\n");
        sb.append("Cant\tSku\tDescripcion\tPrecio\tDescuento\n");
        for(ArticuloCompra articulo: listaCompras){
            sb.append(articulo).
            append("\n");
                    
        }
        return sb.toString() ;
    }

    public void removerArticulo(String sku, int cuantos) {
        int indexOf = listaCompras.indexOf(new ArticuloCompra(new Articulo(sku)));
        ArticuloCompra remArticulo = listaCompras.get(indexOf);
        
        if(cuantos >= remArticulo.getCantidad()){
            listaCompras.remove(remArticulo);
            listaCompras.stream().filter(c->c!=null);
        }else{
            remArticulo.setCantidad(remArticulo.getCantidad() -  cuantos);
        }
        Tienda.devolverArticulo(sku,cuantos);
    }

    public List<ArticuloCompra> getListaCompras() {
        return listaCompras;
    }   
}
