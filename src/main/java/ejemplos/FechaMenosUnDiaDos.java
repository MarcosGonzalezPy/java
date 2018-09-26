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
 * @author konecta
 */
public class FechaMenosUnDiaDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("La fecha es:" + fechaMenosUnDia(new Date()));
    }
    
    
        public static Date fechaMenosUnDia(Date fecha){        
        Calendar calendar = Calendar.getInstance();
        fecha.setDate(1);
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, 1);       
        calendar.add(Calendar.DAY_OF_YEAR, -1);                  
        Integer dia = calendar.getTime().getDate();        
        return calendar.getTime();
    }
    
}
