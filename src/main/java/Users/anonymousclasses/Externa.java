package anonymousclasses;


public class Externa {
    private Operaciones op = new Operaciones(){
        // definición de la clase anonima
      public void imprimir(){         
          System.out.println("Imprimir anonimma");
      }
       
    };// creación del objeto termina con ;
   
    void proceso(){       
        op.imprimir();
    }
    
}