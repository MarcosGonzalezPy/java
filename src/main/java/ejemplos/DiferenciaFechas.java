/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Marcos
 */
public class DiferenciaFechas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Date hoy = new Date(); //Fecha de hoy 
        hoy.setHours(10);
        hoy.setMinutes(30);
        hoy.setSeconds(15);
        int anho = 2016;
        int mes = 1;
        int dia = 13; //Fecha anterior 
        Calendar calendar = new GregorianCalendar(anho, mes - 1, dia);
        java.sql.Date date1 = new java.sql.Date(calendar.getTimeInMillis());
        //Obtener Sysdate
        Calendar calendar2 = new GregorianCalendar((hoy.getYear() + 1900), hoy.getMonth(), hoy.getDate());
        java.sql.Date date2 = new java.sql.Date(calendar2.getTimeInMillis());
        //Fin Sysdate
        double d = diferenciaEnDiasDeDosFechas(date1, date2);
        System.out.println("La fecha 1= " + date1);
        System.out.println("La fecha 2= " + date2);
        System.out.println("La diferencia es: " + d);
              
    }

    public static double diferenciaEnDiasDeDosFechas(Date fecha1, Date fecha2) {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día         
        double diferencia = (fecha1.getTime() - fecha2.getTime()) / MILLSECS_PER_DAY;
        return diferencia;
    }

}
