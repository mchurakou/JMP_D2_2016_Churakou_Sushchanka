package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/**
 * Producer thread. Uses the NumberGenerator to obtain the new number and delivers numbers to queue.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Producer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Producer.class);
    private CountDownLatch prodLatch;
    private CyclicBarrier producersBarrier;
    private int number;
    private int delay = ThreadLocalRandom.current().nextInt(1000, 2000);

    Producer(CountDownLatch prodLatch, CyclicBarrier producersBarrier) {
        this.prodLatch = prodLatch;
        this.producersBarrier = producersBarrier;
    }

    int getNumber() {
        return number;
    }

    @Override
    public void run() {
        String nameThread = Thread.currentThread().getName();
        while ((number = NumberGenerator.getNumber()) != Integer.MIN_VALUE) {
            logger.info(nameThread + " started with number - " + number + ", delay: " + delay);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                producersBarrier.await();
            } catch (BrokenBarrierException|InterruptedException e) {
                logger.error("Producer" + nameThread + "was interrupted.");
                e.printStackTrace();
            }
        }
        prodLatch.countDown();
    }
}
