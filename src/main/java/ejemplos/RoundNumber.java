/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

/**
 *
 * @author Marcos
 */
public class RoundNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = 444.001;
        double b = 444.499;
        double c = 444.5;
        double d = 444.9999;
        float e = (float)Math.round(a);
        float f = (float)Math.round(b);
        float g = (float)Math.round(c);
        float h = (float)Math.round(d);
        System.out.println("a= "+e);
        System.out.println("b= "+f);
        System.out.println("c= "+g);
        System.out.println("d= "+h);
        
    }
    
}
