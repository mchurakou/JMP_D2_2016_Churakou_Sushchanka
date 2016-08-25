package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CountDownLatch;
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
    private CountDownLatch prodLatch;
    private List<Phase> phases;

    public Producer(CountDownLatch prodLatch, List<Phase> phases) {
        this.prodLatch = prodLatch;
        this.phases = phases;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Producer");
        String nameThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        int number;
        while ((number = NumberGenerator.getNumber()) != Integer.MIN_VALUE) {
            System.out.println(nameThread + " started with number - " + number + ", delay: " + delay);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                Broker.put(number);
                logger.info("Added " + number + "to queue.");
            } catch (InterruptedException e) {
                logger.error("Producer" + nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        logger.info("Number generation stopped");
        phases.add(Phase.GENERATION_FINISHED);
        prodLatch.countDown();
        logger.info("Producer " + nameThread +" terminated.");
    }
}
