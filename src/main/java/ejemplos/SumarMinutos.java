/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class SumarMinutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date hora = new Date();
        Date hora2 = new Date();
        int min = 43;
        Date hora3 = sumarMinutosFecha(new Date());
        System.out.println("Hora 1: "+hora);
        System.out.println("Hora 2: "+hora3);
    }
    
    
    public static Date sumarMinutosFecha(Date fecha){
      Calendar calendar = Calendar.getInstance();	
      calendar.setTime(fecha); 
      calendar.add(Calendar.MINUTE, 43); 
      calendar.add(Calendar.SECOND, 12);
      return calendar.getTime();	
 }
    
}
