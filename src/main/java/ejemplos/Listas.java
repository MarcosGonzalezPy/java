/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;


import java.util.Iterator; //Importo la interfaz Iterator para iterar el arrayList
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class Listas {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Definimos una ArrayList
        List<String> listaServicios = new ArrayList<String>();
        
        //listaServicios.add("HOLA");
        //System.out.println(listaServicios.get(0));
        if(listaServicios!=null){
            System.out.println("La lista es nula");
        }
        if(listaServicios.equals(null)){
            System.out.println("La lista no fue nula");
        }else{
            System.out.println("EURECA");
        }
        
        int num = listaServicios.size();
        System.out.println("El tamaño de la lista es: "+num);
    }
}
