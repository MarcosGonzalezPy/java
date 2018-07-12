/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class MonthsBetween {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("02/02/1988");
        Date d2 = sdf.parse("01/01/1995");
        System.out.println(monthsBetween(d, d2));
    }

    public static double monthsBetween(Date startDate, Date endDate) {

        Calendar cal = Calendar.getInstance();

        cal.setTime(startDate);
        int startDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int startMonth = cal.get(Calendar.MONTH);
        int startYear = cal.get(Calendar.YEAR);

        cal.setTime(endDate);
        int endDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int endMonth = cal.get(Calendar.MONTH);
        int endYear = cal.get(Calendar.YEAR);

        int diffMonths = endMonth - startMonth;
        int diffYears = endYear - startYear;
        int diffDays = endDayOfMonth - startDayOfMonth;

        return (diffYears * 12) + diffMonths + diffDays / 31.0;
    }

}
