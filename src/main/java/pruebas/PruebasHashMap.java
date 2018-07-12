/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marcos
 */
public class PruebasHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, Object> resultado = new HashMap<String, Object>();
        long a = 0;
        resultado.put("long",a);
        
        long b = (long) resultado.get("long");
    }
    
}
