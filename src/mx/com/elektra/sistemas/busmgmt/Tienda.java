/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.busmgmt;

import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.sistemas.itemmgmt.Articulo;
import mx.com.elektra.sistemas.itemmgmt.ArticuloCompra;
import mx.com.elektra.sistemas.itemmgmt.ArticuloStock;
import mx.com.elektra.sistemas.itemmgmt.Carrito;

public class Tienda {
    
    private String nombre;
    private String direccion;
    public static InventarioTienda inventario;
    public static int currentIdCompra = 0;
    private List<Compra> compras;
    
    public Tienda(){
        compras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int comprarCarrito(Carrito carrito){
        Compra compra = new Compra();
        compra.getTicket().getListaComprados().addAll( carrito.getListaCompras());
        compra.setStatus("Pagado");
        this.compras.add(compra);
        return compra.getIdCompra();
    }
    
    public Compra buscar(int idCompra){
        return this.compras.get(idCompra - 1);
    }
    
    public static ArticuloCompra obtenerArticulo(String sku, int cantidad){
        
        ArticuloStock articuloSearch = new ArticuloStock(new Articulo(sku), cantidad);
        int indexOf = inventario.getInventario().indexOf(articuloSearch);
        
        ArticuloStock artEncontrado = inventario.getInventario().get(indexOf);
        ArticuloCompra artAgregar;
        if(artEncontrado.validarExistencias(cantidad)){
            artAgregar = new ArticuloCompra(artEncontrado.getArticulo());
            artAgregar.setCantidad(cantidad);
            artEncontrado.setCantidad(artEncontrado.getCantidad() - cantidad);
        }else{
            System.err.println("No hay suficientes Items en Inventario");
            artAgregar = null;
        }
        
        
        return artAgregar;
    }
    
    public static void devolverArticulo(String sku, int cuantos) {
        ArticuloStock articuloSearch = new ArticuloStock(new Articulo(sku), cuantos);
        int indexOf = inventario.getInventario().indexOf(articuloSearch);
        
        ArticuloStock artEncontrado = inventario.getInventario().get(indexOf);
        
        artEncontrado.setCantidad(artEncontrado.getCantidad() + cuantos);
        
        
    }
    
    public static int siguienteIdCompra() {
        return ++Tienda.currentIdCompra;
    }
    
}
