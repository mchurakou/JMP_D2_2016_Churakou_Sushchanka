package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by alt-hanny on 21.08.2016.
 */
public class Producer implements Runnable {

    private static final Logger logger = LogManager.getLogger(Producer.class);
    private Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        int number = NumberGenerator.getNumber();
        logger.info("Producer started with number - " + number);
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            broker.put(number);
            logger.info("Added " + number);
            logger.info("Producer " + Thread.currentThread().getName() +" terminated.");
        } catch (InterruptedException e) {
            logger.error("Producer" + Thread.currentThread().getName() + "was interrapted.");
            e.printStackTrace();
        }
    }
}
