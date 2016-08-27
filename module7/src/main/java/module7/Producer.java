package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Producer thread. Uses the NumberGenerator to obtain the new number and delivers numbers to queue.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Producer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Producer.class);
    private CountDownLatch prodLatch;
    private BlockingQueue<Integer> queue;
    private int delay = ThreadLocalRandom.current().nextInt(1000, 2000);

    Producer(CountDownLatch prodLatch, BlockingQueue<Integer> queue) {
        this.prodLatch = prodLatch;
        this.queue = queue;
        Thread.currentThread().setName("Producer"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        int number;
        while ((number = NumberGenerator.getNumber()) != Integer.MIN_VALUE) {
            logger.info(nameThread + " started with number - " + number + ", delay: " + delay);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                logger.info("Add " + number + "to queue.");
                queue.put(number);
            } catch (InterruptedException e) {
                logger.error("Producer" + nameThread + "was interrapted.");
                e.printStackTrace();
            }
        }
        prodLatch.countDown();
    }
}
