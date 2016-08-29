package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
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
    private CountDownLatch consumLatch;
    private BlockingQueue<Integer> queue;
    private int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
    static SortedSet<String> result = Collections.synchronizedSortedSet(new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            Integer n1 = Integer.parseInt(o1.split("-")[0].trim());
            Integer n2 = Integer.parseInt(o2.split("-")[0].trim());
            return n1 - n2;
        }
    }));

    Consumer(CountDownLatch consumLatch, BlockingQueue<Integer> queue) {
        this.consumLatch = consumLatch;
        this.queue = queue;
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        logger.info(nameThread + " started with " + delay);
        while (!queue.isEmpty() || Runner.isProdusersFinished.getCount() != 0 ) {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                synchronized (queue) {
                    if (result.size() != NumberGenerator.getMaxNumber()) {
                        Integer number = queue.take();
                        String message = number + " - number was handled.";
                        logger.info(message);
                        result.add(message);
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
