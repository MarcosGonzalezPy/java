/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.sql.Timestamp;

/**
 *
 * @author Marcos
 */
public class CompararFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timestamp date1 = new Timestamp(System.currentTimeMillis());
        int dia = date1.getDate();
        date1.setDate(dia);
        Timestamp date2 = new Timestamp(System.currentTimeMillis());

        //System.out.println("La fecha 1= " + date1);
        //System.out.println("La fecha 2= " + date2);
        //System.out.println("La fecha 1= " + date1); 

        if(date2.after(date1)){
            System.out.println(date2+"/date2 es mayor de "+date1+"/date1");
        }else{
            System.out.println(date1+"/date1 es mayor de "+date2+"/date2");
        }
    }
    
}
