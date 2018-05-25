package pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ImprimirDateFormateado {

	public static void main(String[] args) throws ParseException {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    String strDate = sdf.format(cal.getTime());
	    System.out.println(strDate);
	    System.out.println("Hola \n mundo");
	}

}
