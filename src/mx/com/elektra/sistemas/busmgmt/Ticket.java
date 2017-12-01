/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.busmgmt;

import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.sistemas.itemmgmt.ArticuloCompra;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class Ticket {
    private List<ArticuloCompra> listaComprados;
    private double total;
    private double impuestos;
    
    public Ticket(){
        this.listaComprados = new ArrayList<>();
    }

    public List<ArticuloCompra> getListaComprados() {
        return listaComprados;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }
    
    public void imprimirTicket(){
        System.out.println("Desc\tP. Unit\tCant\tTotal\tDesc\tPrecio Final");
        for(ArticuloCompra art:this.listaComprados){
            int cantidad = art.getCantidad();
            float precio = art.getArticulo().getPrecio();
            float totalArt = precio * cantidad;
            float descuento = cantidad * precio * art.getArticulo().getDescuento();
            System.out.print(art.getArticulo().getDescripcion()+"\t");
            System.out.print(precio+"\t");
            System.out.print(cantidad+"\t");
            System.out.print( totalArt +"\t");
            System.out.print(descuento+"\t");
            System.out.println(totalArt-descuento+"\t");
        }
        
        System.out.println("Subtotal\t"+this.total/1.16);
        System.out.println("     IVA\t"+this.impuestos);
        System.out.println("   Total\t"+this.total);
    }
    
}
