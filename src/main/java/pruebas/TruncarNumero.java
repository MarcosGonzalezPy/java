/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author Marcos
 */
public class TruncarNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double i=238.8888888888888888888888888888888; 
        i=(double)((int)(i*100)/100);
        System.out.println("i = " +i);
    }
    
}
