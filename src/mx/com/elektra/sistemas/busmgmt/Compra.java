/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.busmgmt;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class Compra {
    private int idCompra;
    private Ticket ticket;
    private String status;
   
    private Factura factura;
    public Compra(){
        this.idCompra = Tienda.siguienteIdCompra();
        this.status = "pendiente";
        this.ticket = new Ticket();
    }

    public int getIdCompra() {
        return idCompra;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
     public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
