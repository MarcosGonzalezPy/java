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
public class SumarDiasHorasMinutosSegundos {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hora 0: " + new Date());
        System.out.println("Hora 1: " + sumarFecha(new Date(), 0, 26 , 0, 0));

    }

    public static Date sumarFecha(Date fecha, int dias, int horas, int minutos, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DATE, dias);
        calendar.add(Calendar.HOUR, horas);
        calendar.add(Calendar.MINUTE, minutos);
        calendar.add(Calendar.SECOND, segundos);
        return calendar.getTime();
    }

}
