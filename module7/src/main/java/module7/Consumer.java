package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * Consumer thread. Handles the number. Transforms number to String and writes numbers into file.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Consumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private CountDownLatch consumLatch;
    private CyclicBarrier consumersBarrier;
    private BlockingQueue<Integer> queue;
    private String message;
    private SortedSet<String> resultSet;
    private int delay = ThreadLocalRandom.current().nextInt(1000, 2000);

    Consumer(CountDownLatch consumLatch, CyclicBarrier consumersBarrier, BlockingQueue<Integer> queue, SortedSet<String> resultSet) {
        this.consumLatch = consumLatch;
        this.consumersBarrier = consumersBarrier;
        this.queue = queue;
        this.resultSet = resultSet;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        logger.info(nameThread + " started with " + delay);
        while (!queue.isEmpty() || Runner.isProdusersFinished.getCount() != 0 ) {
            try {
                if (resultSet.size() != NumberGenerator.getMaxNumber()) {
                    Integer number = queue.take();
                    message = number + " - number was handled.";
                    TimeUnit.MILLISECONDS.sleep(delay);
                    logger.info(message);
                    consumersBarrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                logger.error(nameThread + "was interrupted.");
                e.printStackTrace();
            }
        }
        consumLatch.countDown();
    }
}
