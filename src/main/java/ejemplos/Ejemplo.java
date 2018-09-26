/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

import java.sql.Timestamp;

/**
 *
 * @author Marcos
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        java.sql.Date date = new java.sql.Date(timeStamp.getTime()); 
    }
    
    public static void imprimir(String nombre, String apellido){
        System.out.println(nombre+", "+apellido);
    }
}
