package anonymousclasses;


public class Externa {
    private Operaciones op = new Operaciones(){
        // definici�n de la clase anonima
      public void imprimir(){         
          System.out.println("Imprimir anonimma");
      }
       
    };// creaci�n del objeto termina con ;
   
    void proceso(){       
        op.imprimir();
    }
    
}