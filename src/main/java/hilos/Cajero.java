
package hilos;

/**
 *
 * @author Marcos
 */
public class Cajero {
    
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp){
        System.out.println("El cajero: " + this.nombre +
        " comienza a procesar la compra del cliente: "+ cliente.getNombre()+
        "en el tiempo: "+ (System.currentTimeMillis()- timeStamp)/1000 + "seg");
        
        for(int i=0; i< cliente.getCarroCompra().length; i++){
            this.esperarXSegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto "+(i + 1) +  
            " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + 
            cliente.getNombre() + " EN EL TIEMPO: " + 
            (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    
    private void esperarXSegundos(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

