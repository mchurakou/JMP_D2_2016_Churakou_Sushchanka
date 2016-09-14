import java.sql.Timestamp;

import static java.sql.Timestamp.valueOf;

/**
 * Created by alt-hanny on 14.09.2016.
 */
public class DBUtils {
    public static Timestamp generateRandomTimastamp() {
        long offset = valueOf("1916-01-01 00:00:00").getTime();
        long end = valueOf("2016-09-16 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }
}
