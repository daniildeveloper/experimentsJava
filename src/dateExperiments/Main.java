package dateExperiments;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Lama
 */
public class Main {

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        System.out.println(c.get(Calendar.WEEK_OF_YEAR));
    }

}
