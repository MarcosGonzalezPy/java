/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author konecta
 */
public class Trim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomnbre = null;
        String apellido = "Gonzalez";
        String razonSocial = ( (nomnbre== null ? "" :nomnbre) +" "+apellido).trim();
        System.out.println(razonSocial);
    }
    
}
