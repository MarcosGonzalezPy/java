/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author konecta
 */
public class SaveFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         FileWriter file = new FileWriter("C:\\prueba-json\\test.txt");
		    try {
		    	file.write("PRUEBA JSON NETBEANS");
			} catch (Exception e) {
				System.out.println("Error al escribir.");
			}
		    file.flush();
		    file.close();
    }
    
}
