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
 * @author marcos
 */
public class CompararFechas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = sdf.parse("1995-02-26");
        Date fechaFin = sdf.parse("1995-02-27");
        Date fechaInicioNueva = sdf.parse("1995-02-28");
        Date fechaFinNueva = sdf.parse("1995-02-28");
        
        //System.out.println("inicio < inicioNuevo " + fechaInicio.before(fechaInicioNueva));
        //System.out.println("fin < finNueva " + fechaFin.before(fechaFinNueva));
        System.out.println("inicioNueva < incio");
    }
    
}
