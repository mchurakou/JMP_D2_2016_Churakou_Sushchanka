package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private CountDownLatch consumLatch;
    private List<String> resultsList = new ArrayList<>();

    Consumer(CountDownLatch consumLatch) {
        this.consumLatch = consumLatch;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Consumer");
        String nameThread = Thread.currentThread().getName();
        int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
        logger.info(nameThread + "started with " + delay);
        while (!Broker.isEmptyQueue()){
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                Integer number = Broker.poll();
                if (number != null) {
                    String message = number + "- number was handled.";
                    resultsList.add( number.intValue(), message);
                    writeToTile(resultsList);
                }
            } catch (InterruptedException e) {
                logger.error(nameThread + "was interrapted.");
                e.printStackTrace();
            }

            while (!resultsList.isEmpty()) {
                writeToTile(resultsList);
            }
        }
    }

    private void writeToTile(List<String> resultsList) {
        if (resultsList.size() == NumberGenerator.getMaxNumber()) {
            for (String result : resultsList) {
                taskLogger.info(result);
            }
        } else return;
    }
}
