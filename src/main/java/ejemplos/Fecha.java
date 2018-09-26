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
 * @author Home
 */
public class Fecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Date date = fecha();
        //System.out.print("La fecha es "+ date);

    }

    public Date fecha() {
        Date fecSys = null;
        Calendar fecha = Calendar.getInstance();
        int anhoSys = fecha.get(Calendar.YEAR);
        int mesSys = fecha.get(Calendar.MONTH);
        mesSys++;
        int diaSys = fecha.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");

        try {
            StringBuilder filtro = new StringBuilder();

            filtro.append(diaSys);
            filtro.append("/");
            filtro.append(mesSys);
            filtro.append("/");
            filtro.append(anhoSys);

            fecSys = formato.parse(filtro.toString());
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fecSys;
    }

}
