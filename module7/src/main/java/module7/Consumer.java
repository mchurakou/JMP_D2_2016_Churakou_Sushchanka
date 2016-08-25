package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Consumer thread. Handles the number. Transforms number to String and writes numbers into file.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Consumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private static final Logger taskLogger = LogManager.getLogger("ConcurrencyTaskLogger");
    private CountDownLatch consumLatch;
    private List<Phase> phases;

    Consumer(CountDownLatch consumLatch, List<Phase> phases) {
        this.consumLatch = consumLatch;
        this.phases = phases;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Consumer");
        String nameThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        logger.info(nameThread + " started with " + delay);
        while (!Broker.isEmptyQueue() || !phases.contains(Phase.GENERATION_FINISHED)){
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                Integer number = Broker.poll();
//                Inspector inspector = Inspector.getStatus();
//                if (inspector.globalStatus != null)
//                    inspector.globalStatus.await();
//                inspector.localStatus.countDown();
                System.out.println(number);
                if (number != null) {
                    String message = Integer.toString(number) + "- number was handled.";
                    taskLogger.info(message);
                }
            } catch (InterruptedException e) {
                logger.error(nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        consumLatch.countDown();


    }



}
