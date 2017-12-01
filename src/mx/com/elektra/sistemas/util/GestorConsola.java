/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.sistemas.util;

import java.util.Scanner;

/**
 *
 * @author 171127 Grupo Salinas
 */
public class GestorConsola {
       
    public static int readIntFromKeyboard(String msg){
        Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        int dato = teclado.nextInt();
        return dato;
    }
    
    public static String redStringFromKeyboard(String msg){
        Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        return teclado.next();
    }

    public static boolean askForContinue() {
         Scanner teclado = new Scanner(System.in);
        System.out.print("Continuar comprando Si - s / No - n: ");
        Character r = teclado.next().charAt(0);
        return r.equals('s');
    }
    
    public static boolean askForDelete() {
         Scanner teclado = new Scanner(System.in);
        System.out.print("Deseas borrar algun articulo del carrito Si - s / No - n: ");
        Character r = teclado.next().charAt(0);
        return r.equals('s');
    }
     public static String readStringLine(String msg) {
         Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        return teclado.nextLine();
    }
}
