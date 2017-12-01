package mx.com.elektra.sistemas.pdv;
import java.io.IOException;

import mx.com.elektra.sistemas.itemmgmt.Articulo;
import mx.com.elektra.sistemas.itemmgmt.Carrito;
import mx.com.elektra.sistemas.busmgmt.InventarioTienda;
import mx.com.elektra.sistemas.busmgmt.Tienda;
import mx.com.elektra.sistemas.util.GestorConsola;

public class PDVMain {


    public static void main(String[] args) throws IOException {
        // say a welcome message
        System.out.println("Bienvenido al sistema Punto de Venta");
        //show selling items
        Tienda.inventario = new InventarioTienda();
        
        Tienda miniAlx = new Tienda();
        miniAlx.setNombre(".:Mini Super Alex:.");
        System.out.println(miniAlx.getNombre());
        Carrito carrito=null;

        mainMenu(carrito,miniAlx);

        //generate and print ticket
            //tax calculation (IVA 16%)
            //discount (item, quantity, amount)
        //invoice
            //search client by RFC
            //create a customer
            //print invoice
        //close session or to buy again
    }

    public static void mainMenu(Carrito carrito, Tienda tienda) {
        //Runtime.getRuntime().exec("cls");
        System.out.println("...::| Menu Principal |::...");
        System.out.println("1 --> Mostrar Inventario");
        System.out.println("2 --> Agregar productos a carrito");
        System.out.println("3 --> Mostrar Carrito");
        System.out.println("4 --> Quitar productos de carrito");
        System.out.println("5 --> Comprar carrito");
        System.out.println("6 --> Mostrar lista de Compras");
        System.out.println("7 --> Salir");
        int opcMenu = GestorConsola.readIntFromKeyboard("Seleccione una opcion: ");
        switch(opcMenu){
            case 1: mostrarInventario(carrito,tienda); break;
            case 2: agregarProductosCarrito(carrito,tienda);break;
            case 3: mostrarCarrito(carrito,tienda); break;
            case 4: eliminarCarrito(carrito,tienda);  break;
            case 5: comprarCarrito(carrito, tienda); break;
            case 6: tienda.imprimirCompras();
                mainMenu(carrito,tienda);break;
            case 7: break;
            default: System.out.println("Seleccion no valida");
                mainMenu(carrito,tienda);
        }
    }

    private static void mostrarInventario(Carrito carrito,Tienda tienda) {
        System.out.println(Tienda.inventario);
        mainMenu(carrito,tienda);
    }

    static void agregarProductosCarrito(Carrito carrito, Tienda tienda){
        //add items to cart
        if(carrito == null)
            carrito = new Carrito();
        do{
            String sku = GestorConsola.redStringFromKeyboard("Que articulo deseas agregar: ");
            int cant = GestorConsola.readIntFromKeyboard("Cuantos: ");
            carrito.agregarArticulo(sku, cant);
        }while(GestorConsola.askForContinue());
        mainMenu(carrito,tienda);
    }

    static void mostrarCarrito(Carrito carrito,Tienda tienda){
        if(carrito == null || carrito.getListaCompras().isEmpty()){
            System.out.println("No hay productos en el carrito");
        }else{
            System.out.print(carrito);
        }
        mainMenu(carrito,tienda);
    }

    static void eliminarCarrito(Carrito carrito,Tienda tienda){
        //delete items from cart
        while(GestorConsola.askForDelete()){
            carrito.removerArticulo(
                    GestorConsola.redStringFromKeyboard("Que articulo deseas remover: "),
                    GestorConsola.readIntFromKeyboard("Cuantos ? : "));
        }
        mainMenu(carrito,tienda);
    }

    static  void comprarCarrito(Carrito carrito, Tienda miniAlx){
        if (carrito == null){
            System.out.println("No hay productos en el carrito");
            mainMenu(carrito,miniAlx);
        }
        //purchase items from cart
        //generate order id
        int idCompra = miniAlx.comprarCarrito(carrito);

        miniAlx.buscar(idCompra).getTicket().imprimirTicket();

        carrito = null;

        mainMenu(carrito,miniAlx);
    }

    static void facturar(){

    }
    
}
