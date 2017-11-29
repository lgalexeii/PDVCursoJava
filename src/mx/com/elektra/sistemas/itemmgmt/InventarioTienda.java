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
public class InventarioTienda {
    private List<ArticuloStock> inventario;

    public InventarioTienda() {
        this.inventario = new ArrayList<>();
        this.inventario.add(new ArticuloStock(new Articulo("1224", "Rabbit", 12.99f, 0.01f), 10));
        this.inventario.add(new ArticuloStock(new Articulo("1225", "Donkey", 12.99f, 0.51f), 1));
        this.inventario.add(new ArticuloStock(new Articulo("1226", "Kitten", 12.99f, 0.0f), 10));
    }

    public List<ArticuloStock> getInventario() {
        return inventario;
    }

    public void setInventario(List<ArticuloStock> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InventarioTienda: " + "\n");
        sb.append("Cant\tSku\tDescripcion\tPrecio\tDescuento\n");
        for(ArticuloStock articulo: inventario){
            sb.append(articulo).
            append("\n");
                    
        }
        return sb.toString() ;
    }
    
}
