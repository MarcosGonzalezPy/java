package Users.enumexample;

public class PruebaEnum {
	public enum Demarcacion{PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
	
	public static void main(String[] algo){
		
		Demarcacion delantero = Demarcacion.DELANTERO;    // Instancia de un enum de la clase Demarcación
		Demarcacion portero = Demarcacion.PORTERO;
		System.out.println(delantero.name());    // Devuelve un String con el nombre de la constante (DELANTERO)
		System.out.println(delantero.toString());    // Devuelve un String con el nombre de la constante (DELANTERO)
		System.out.println(delantero.ordinal());    // Devuelve un entero con la posición del enum según está declarada (3).
		System.out.println(delantero.compareTo(portero));    // Compara el enum con el parámetro según el orden en el que están declarados lo enum
		//System.out.println(Demarcacion.values());
		
		Mazos mazo = Mazos.BASTO;
		System.out.println(mazo.name());
		//System.out.println(mazo.values());
	}
}
