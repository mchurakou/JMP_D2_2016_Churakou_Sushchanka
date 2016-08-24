package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
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
    private List<Phase> phases;
    private CountDownLatch consumLatch;

    Consumer(List<Phase> phases, CountDownLatch consumLatch) {
        this.phases = phases;
        this.consumLatch = consumLatch;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Consumer");
        String nameThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        logger.info(nameThread + "started with " + delay);
        while (!Broker.isEmptyQueue() || !phases.contains(Phase.GENERATION_FINISHED)
                || !phases.contains(Phase.PRODUCERS_FINISH)){
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                String number = Broker.poll();
                if (number != null) {
                    String message = number + "- number was handled.";
                    taskLogger.info(message);
                }
            } catch (InterruptedException e) {
                logger.error(nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        logger.info(nameThread + " terminated.");
        consumLatch.countDown();
    }
}
