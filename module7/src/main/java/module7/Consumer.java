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
    private Integer number;
    private int delay = ThreadLocalRandom.current().nextInt(1000, 2000);
    private SortedSet<String> result;

    Consumer(CountDownLatch consumLatch, CyclicBarrier consumersBarrier, BlockingQueue<Integer> queue) {
        this.consumLatch = consumLatch;
        this.consumersBarrier = consumersBarrier;
        this.queue = queue;
    }

    public SortedSet<String> getResult() {
        return result;
    }

    @Override
    public void run() {
        result = Collections.synchronizedSortedSet(new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer n1 = Integer.parseInt(o1.split("-")[0].trim());
                Integer n2 = Integer.parseInt(o2.split("-")[0].trim());
                return n1 - n2;
            }
        }));
        String nameThread = Thread.currentThread().getName();
        logger.info(nameThread + " started with " + delay);
        while (!queue.isEmpty() || Runner.isProdusersFinished.getCount() != 0 ) {
            try {
                if (result.size() != NumberGenerator.getMaxNumber()) {
                    number = queue.take();
                    TimeUnit.MILLISECONDS.sleep(delay);
                    String message = number + " - number was handled.";
                    logger.info(message);
                    consumersBarrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                logger.error(nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        consumLatch.countDown();
    }
}
