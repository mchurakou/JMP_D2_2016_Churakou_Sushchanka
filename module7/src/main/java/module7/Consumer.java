package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Consumer thread. Handles the number. Transforms number to String and writes numbers into file.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Consumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private static final Logger taskLogger = LogManager.getLogger("ConcurrencyTaskLogger");
    private CountDownLatch consumLatch;
    int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
    private List<Phase> phases;
    private static AtomicInteger syncNumber = new AtomicInteger(1);

    Consumer(CountDownLatch consumLatch, List<Phase> phases) {
        this.consumLatch = consumLatch;
        this.phases = phases;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Consumer");
        String nameThread = Thread.currentThread().getName();
        logger.info(nameThread + " started with " + delay);
        while (!Broker.isEmptyQueue() || !phases.contains(Phase.GENERATION_FINISHED)){
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                Integer number = Broker.poll();
                logger.info(number +"" + syncNumber);
                if (number != null ) {
                     if (number == syncNumber.get()) {
                         String message = Integer.toString(number) + "- number was handled.";
                         taskLogger.info(message);
                         syncNumber.incrementAndGet();
                     }
                }
            } catch (InterruptedException e) {
                logger.error(nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        consumLatch.countDown();

    }
}
