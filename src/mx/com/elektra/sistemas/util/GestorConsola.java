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
        int dato = teclado.nextInt();
        return dato;
    }
    
    public static String redStringFromKetboard(String msg){
        Scanner teclado = new Scanner(System.in);
        
        return teclado.next();
    }
    
}
