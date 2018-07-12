/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

/**
 *
 * @author Home
 */
public class For {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**    FOR I IN 1..LENGTH(V_VAR1) LOOP

        V_VAR2 := V_VAR2 || SUBSTR(V_VAR1, I * (-1), 1);

        END LOOP;*/
        String cadena = "123456";
        String cadena2 = "";
        for(int i=1; i< cadena.length(); i++){
            cadena2 =  cadena2+ cadena.substring( i*(-1),1);
            System.out.println("La cadena es: " + cadena2);
        }
    }
    
}
