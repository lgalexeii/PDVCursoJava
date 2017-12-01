package mx.com.elektra.sistemas.pdv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import mx.com.elektra.sistemas.busmgmt.Cliente;

import mx.com.elektra.sistemas.itemmgmt.Carrito;
import mx.com.elektra.sistemas.busmgmt.InventarioTienda;
import mx.com.elektra.sistemas.busmgmt.Tienda;
import mx.com.elektra.sistemas.util.GestorConsola;

public class PDVMain {


    public static void main(String[] args) {
        // say a welcome message
        System.out.println("Bienvenido al sistema Punto de Venta");
        //show selling items
        Tienda.inventario = new InventarioTienda();
        
        Tienda miniAlx = new Tienda();
        miniAlx.setNombre(".:Mini Super Alex:.");
        System.out.println(miniAlx.getNombre());
        Carrito carrito=null;
        boolean continuar = true;
        //menu principal
        do{
             System.out.println("...::| Menu Principal |::...");
            System.out.println("1 --> Mostrar Inventario");
            System.out.println("2 --> Agregar productos a carrito");
            System.out.println("3 --> Mostrar Carrito");
            System.out.println("4 --> Quitar productos de carrito");
            System.out.println("5 --> Comprar carrito");
            System.out.println("6 --> Mostrar lista de Compras");
            System.out.println("7 --> Facturar");
            System.out.println("0 --> Salir");
            int opcMenu = GestorConsola.readIntFromKeyboard("Seleccione una opcion: ");
            switch(opcMenu){
                case 0: continuar = false; break;
                case 1: mostrarInventario(); break;
                case 2: 
                    //add items to cart
                    if(carrito == null)
                        carrito = new Carrito();
                    do{
                        String sku = GestorConsola.redStringFromKeyboard("Que articulo deseas agregar: ");
                        int cant = GestorConsola.readIntFromKeyboard("Cuantos: ");
                        carrito.agregarArticulo(sku, cant);
                    }while(GestorConsola.askForContinue());
                    break;
                case 3: mostrarCarrito(carrito); break;
                case 4: eliminarCarrito(carrito);  break;
                case 5: comprarCarrito(carrito, miniAlx); 
                        carrito = null; break;
                case 6: miniAlx.imprimirCompras();break;
                case 7: facturar(miniAlx); break;
                default: System.out.println("Seleccion no valida");
            }
        }while(continuar);

        System.out.println(".:Gracias por su preferencia:.");
        //generate and print ticket
            //tax calculation (IVA 16%)
            //discount (item, quantity, amount)
        //invoice
            //search client by RFC
            //create a customer
            //print invoice
        //close session or to buy again
    }

    
    private static void mostrarInventario() {
        System.out.println(Tienda.inventario);
    }


    static void mostrarCarrito(Carrito carrito){
        if(carrito == null || carrito.getListaCompras().isEmpty()){
            System.out.println("No hay productos en el carrito");
        }else{
            System.out.print(carrito);
        }
    }

    static void eliminarCarrito(Carrito carrito){
        //delete items from cart
        if(carrito == null){
            System.out.println("El carrito ya esta vacio");
            return;
        }
        while(GestorConsola.askForDelete()){
            carrito.removerArticulo(
                    GestorConsola.redStringFromKeyboard("Que articulo deseas remover: "),
                    GestorConsola.readIntFromKeyboard("Cuantos ? : "));
        }
    }

    static  void comprarCarrito(Carrito carrito, Tienda miniAlx){
        if (carrito == null){
            System.out.println("No hay productos en el carrito");
            return;
        }
        //purchase items from cart
        //generate order id
        int idCompra = miniAlx.comprarCarrito(carrito);
        miniAlx.buscar(idCompra).getTicket().imprimir();
    }

    static void facturar(Tienda t){
        System.out.println("Seleccione una opcion");
        System.out.println("1 --> Buscar cliente por RFC");
        System.out.println("2 --> Registrar cliente");
        int opcFacturar = GestorConsola.readIntFromKeyboard("Opcion: ");
        switch(opcFacturar){
            case 1: 
                String rfc = GestorConsola.redStringFromKeyboard("RFC del cliente");
                Optional<Cliente> clFac = t.buscarCliente(rfc);
                if(clFac.isPresent()){
                    //mostrar compras
                    t.imprimirCompras();
                    int idCompra = GestorConsola.readIntFromKeyboard("Ingrese el ticket a facturar: ");
                    t.facturar(clFac.get(), idCompra); 
                }
                break;
            case 2:            
            Cliente cliente = t.crearCliente(GestorConsola.readStringLine("Nombre: "), 
                GestorConsola.readStringLine("Direccion: "),
                GestorConsola.readStringLine("RFC: "));
                 t.imprimirCompras();
                    int idCompra = GestorConsola.readIntFromKeyboard("Ingrese el ticket a facturar: ");
                    t.facturar(cliente, idCompra); 
                break;
            default : System.out.println("Seleccione una opcion valida");
            break;
        }
    }
    
}
