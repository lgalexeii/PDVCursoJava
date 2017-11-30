package mx.com.elektra.sistemas.pdv;
import mx.com.elektra.sistemas.itemmgmt.Articulo;
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
        System.out.println(Tienda.inventario);
        
        //add items to cart
        Carrito carrito = new Carrito();
        do{
             String sku = GestorConsola.redStringFromKeyboard("Que articulo deseas agregar: ");
            int cant = GestorConsola.readIntFromKeyboard("Cuantos: ");
            carrito.agregarArticulo(sku, cant);
        }while(GestorConsola.askForContinue());
        
       
        //show items in cart
        
        System.out.println(carrito);
        //inventario reducido
        System.out.println(Tienda.inventario);
        
        //delete items from cart
        
        while(GestorConsola.askForDelete()){
            carrito.removerArticulo( 
                    GestorConsola.redStringFromKeyboard("Que articulo deseas remover: "),
                    GestorConsola.readIntFromKeyboard("Cuantos ? : "));
        }
        
        System.out.println(carrito);
        //inventario restaurado
        System.out.println(Tienda.inventario);
        
        //purchase items from cart
            //generate order id
        int idCompra = miniAlx.comprarCarrito(carrito);
        
        miniAlx.buscar(idCompra).getTicket().imprimirTicket();
            
        //generate and print ticket
            //tax calculation (IVA 16%)
            //discount (item, quantity, amount)
        //invoice
            //search client by RFC
            //create a customer
            //print invoice
        //close session or to buy again
    }
    
}
