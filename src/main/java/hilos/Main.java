
package hilos;

/**
 *
 * @author Marcos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	Cliente cliente1 = new Cliente("Luis", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Hector", new int[] { 1, 3, 5, 1, 1 });

		Cajero cajera1 = new Cajero("Cajera 1");
		Cajero cajera2 = new Cajero("Cajera 2");

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();

		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
    }
    
}
