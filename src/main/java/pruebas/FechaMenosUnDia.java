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
 * @author Home
 */
public class FechaMenosUnDia { 
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        Parameters:
        year - the year minus 1900; must be 0 to 8099. (Note that 8099 is 9999 minus 1900.)
        month - 0 to 11
        day - 1 to 31
        */
        
        //Date fecha = new Date(88,06,18);
        Date fecha = new Date();
        System.out.println(formatSimpleDate(fecha.getDate(), fecha.getMonth()) );
        System.out.println(formatSimpleDate(fechaMenosUnDia(fecha).getDate(),fechaMenosUnDia(fecha).getMonth()));
        
    }
    
    public static Date fechaMenosUnDia(Date fecha){        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.add(Calendar.MONTH, 1);                    
        Integer dia = calendar.getTime().getDate();        
        return calendar.getTime();
    }
    
    public static String formatSimpleDate(Integer dia, Integer mes){
        String resultado = "";
        if(dia<10){
            resultado = "0"+ dia.toString()+"/";
        }else{
            resultado = dia.toString()+"/";
        }
        if(mes<10){
            resultado = resultado + "0" + mes.toString();
        }else{
            resultado = resultado + mes.toString();
        }        
        return resultado;   
    }
}
