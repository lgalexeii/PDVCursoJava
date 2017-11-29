/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.itemmgmt;

public class Tienda {
    private String nombre;
    private String direccion;
    public static InventarioTienda inventario;

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
    public static ArticuloCarrito obtenerArticulo(Articulo art, int cantidad){
        int indexOf = inventario.getInventario().indexOf(art);
        
        ArticuloStock artEncontrado = inventario.getInventario().get(indexOf);
        artEncontrado.validarExistencias(cantidad);
        
        //ArticuloCarrito artAgregar = (ArticuloCarrito) inventario.getInventario().get(indexOf);
//        artEncontrado.setPrecioTotal(artEncontrado.getArticulo().getPrecio() * cantidad);
        return null;
    }
}
