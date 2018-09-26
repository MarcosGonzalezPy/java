/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class CrearUnDateConFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2020-12-31";
        Date nuevaFecha = null;
        try {
            nuevaFecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println("La fecha es= "+nuevaFecha.getTime());
    }

}
