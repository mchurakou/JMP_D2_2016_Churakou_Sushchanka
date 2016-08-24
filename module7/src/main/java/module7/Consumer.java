package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Consumer thread. Handles the number. Transforms number to String and writes numbers into file.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Consumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private static final Logger taskLogger = LogManager.getLogger("ConcurrencyTaskLogger");
    private Broker broker;

    Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        final String currentThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        logger.info("Consumer started " + currentThread);
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
            Integer number = broker.poll();
            if (number != null) {
                String message = Integer.toString(number) + "- number was handled.";
                taskLogger.info(message);
                logger.info(currentThread);
            }
            logger.info("Consumer " + currentThread + " terminated.");
        } catch (InterruptedException e) {
            logger.error("Consumer" + currentThread + "was interrapted.");
            e.printStackTrace();
        }
    }
}
