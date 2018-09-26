/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class DiferenciaFechas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
        Date d = sdf.parse("01/01/1995 11");
        Date d2 = sdf.parse("01/01/1995 00");
        System.out.println("D1= "+d);
        System.out.println("D2= "+d2);
        System.out.println("Diferencia= "+diferenciaEnDiasDeDosFechas(d, d2));
    }
    
    public static float diferenciaEnDiasDeDosFechas(Date fecha1, Date fecha2) {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día         
        double diferencia = (fecha1.getTime() - fecha2.getTime()) ;/// MILLSECS_PER_DAY;
        double dias =(diferencia / (1000 * 60 * 60 * 24));
        //redondear
        float redondeado = (float)Math.round(dias);
        return redondeado;
    }
    
    
    
    
 
}
