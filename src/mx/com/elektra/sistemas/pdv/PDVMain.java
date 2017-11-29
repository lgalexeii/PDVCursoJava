package mx.com.elektra.sistemas.pdv;
import mx.com.elektra.sistemas.itemmgmt.Carrito;
import mx.com.elektra.sistemas.itemmgmt.InventarioTienda;
import mx.com.elektra.sistemas.itemmgmt.Tienda;

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
        
        miniAlx.obtenerArticulo(null, 0);
        
        //add items to cart
        Carrito carrito = new Carrito();
        
        //show items in cart
        
        //delete items from cart
        
        //purchase items from cart
            //generate order id
            
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
