/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class TruncateDate {
    
    public static void main(String[] args) {
        Date fecha = new Date();
        System.out.println("La fecha es: " +fecha);
        System.out.println("La fecha modificada es: " +removeTime(fecha));
        
        
        //Para probar verifFecVigCon
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2015-10-11";
        Date nuevaFecha = null;
        try {
            nuevaFecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println("La fecha "+strFecha+" es menor o igual que sysdate: "+verifFecVigCon(nuevaFecha));
    }
    
    public static boolean verifFecVigCon (Date fecha){
        Date fechaTrunc = removeTime(fecha);
        Date sysdateTrunc = removeTime(new Date());
       // IF TRUNC (v_fec_fincont) <= TRUNC (SYSDATE)
        if(!fechaTrunc.after(sysdateTrunc)){
            return true;
        }else{
            return false;
        }
    }
    
     public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
}
