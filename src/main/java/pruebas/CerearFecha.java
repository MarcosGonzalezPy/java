/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class CerearFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date sysdate = new Date();
        System.out.println("Fecha "+sysdate);  
        sysdate.setDate(0);
        Date sysdate2 =sumarFecha(sysdate, 1, 15, 0, 0, 0);
        System.out.println("Fecha "+sysdate2);
    }
    
        public static Date sumarFecha(Date fecha,int meses, int dias, int horas, int minutos, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, meses);
        calendar.add(Calendar.DATE, dias);
        calendar.add(Calendar.HOUR, horas);
        calendar.add(Calendar.MINUTE, minutos);
        calendar.add(Calendar.SECOND, segundos);
        return calendar.getTime();
    }
    
}
