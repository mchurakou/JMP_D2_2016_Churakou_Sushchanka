package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Producer thread. Uses the NumberGenerator to obtain the new number and delivers numbers to queue.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Producer implements Runnable {

    private static final Logger logger = LogManager.getLogger(Producer.class);
    private static final Logger taskLogger = LogManager.getLogger("ConcurrencyTaskLogger");
    private Broker broker;

    Producer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        final String nameThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        System.out.println("producer" + delay);
        int number;
        while ((number = NumberGenerator.getNumber()) != Integer.MIN_VALUE) {
            System.out.println(nameThread + " started with number - " + number);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                broker.put(number);
                taskLogger.info("Added " + number + "to queue.");
                logger.info("Producer " + nameThread +" terminated.");
            } catch (InterruptedException e) {
                logger.error("Producer" + nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
    }
}
