import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import static java.sql.Timestamp.valueOf;

/**
 * Created by alt-hanny on 14.09.2016.
 */
public class DBUtils {
    public static Timestamp generateRandomTimastamp(String beginning, String ending ) {
        long offset = valueOf(beginning).getTime();
        long end = valueOf(ending).getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }

    public static Date generateRandomDate(int beginning, int ending) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.DAY_OF_YEAR, 1);
        calendar.set(GregorianCalendar.YEAR, beginning);
        long offset = calendar.getTimeInMillis();
        calendar.set(GregorianCalendar.DAY_OF_YEAR, 1);
        calendar.set(GregorianCalendar.YEAR, ending);
        long end = calendar.getTimeInMillis();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return new Date(randomTimestamp.getTime());
    }
}
