/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

/**
 *
 * @author Marcos
 */
public class VarrayEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = obtenerMonto("1","2","3","4");
        System.out.println("El valor a: "+a);
        
        double b = obtenerMonto("1","2","3","");
        System.out.println("El valor a: "+b);
        
        double c = obtenerMonto("1","2",null,null);
        System.out.println("El valor a: "+c);
    }
    
    public static double obtenerMonto(String planLla,
            String planSMS,String planDat,String planSer){
        
        String[] lista = {planLla, planSMS, planDat, planSer};
        double montoTotal = 0;
        
        for(int i=0; i<lista.length; i++){
            double montoPlan=0;
            double montoIVA=0;
            String codPlan = lista[i];
            if(codPlan != null && !codPlan.isEmpty()){
                montoPlan = 1000;//llamar a fg_valor
            }
            if(montoPlan > 0){
                montoIVA = 1000; //llamar a fg_valor
            }
            if(montoIVA >0){
                montoIVA = montoIVA/100;
                montoPlan = Math.ceil( montoPlan + Math.round((montoPlan*montoIVA*100)/100));
            }
            
            montoTotal = montoTotal + montoPlan;
        }
        
        return montoTotal;
    }
    
}
