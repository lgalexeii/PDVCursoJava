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
class Factura extends Ticket{    
    private Cliente cliente;

    Factura(Ticket ticket) {
        super();
        this.getListaComprados().addAll( ticket.getListaComprados() );
        this.setImpuestos(ticket.getImpuestos() );
        this.setTotal(ticket.getTotal());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public void imprimir(){
        System.out.println("Cliente: " + this.cliente.getNombre() );
        System.out.println("RFC: " + this.cliente.getRfc() );
        System.out.println("Domicilio Fiscal: " + this.cliente.getDireccion());
        super.imprimir();
    }
}
