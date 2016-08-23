package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


/**
 * Created by alt-hanny on 21.08.2016.
 */
class NumberGenerator {

    static private int number;

    static int getNumber() {
        return number++;
    }
}
