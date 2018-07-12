/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varios;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class CadenaDentroArray {
    
    public static void main(String[] args){
        List<String> listaNombre = new ArrayList<String>();
        listaNombre.add("HOLA");
        listaNombre.add("MUNDO");
        
        System.out.println("Existe MUNDO dentro de la cadena? = "+ existe("MUNDO", listaNombre));
    
    }
    
    public static boolean existe(String cadena, List<String> lista){
       for(String subCadena: lista){
           if(cadena.equals(subCadena)){
               return true;
           }
       }
       return false; 
    }
    

    
}
