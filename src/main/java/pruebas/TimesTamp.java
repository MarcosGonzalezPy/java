/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Home
 */
public class TimesTamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String S = new SimpleDateFormat("MM/dd/yyyy").format(date);
        //String fecha = date.toString();
        System.out.println("La fecha es: "+S);
    }

}
