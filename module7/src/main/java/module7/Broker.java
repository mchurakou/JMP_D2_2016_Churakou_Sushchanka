package module7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Helper class. Puts and polls number in queue.
 *
 * Created by alt-hanny on 23.08.2016.
 */
class Broker {
    /** Queue for storing numbers. */
    private BlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);

    /**
     * Puts numbers into queue.
     * @param value Value of the generated numbers.
     * @throws InterruptedException InterruptedException.
     */
    void put(Integer value) throws InterruptedException {
        queue.put(value);
    }

    /**
     * Polls numbers from queue.
     * @return Value of the generated number from queue.
     * @throws InterruptedException InterruptedException.
     */
    Integer poll() throws InterruptedException {
        System.out.println("*************" + queue.size());
        return queue.poll();
    }
}
