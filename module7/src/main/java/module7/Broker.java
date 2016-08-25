package module7;

import java.util.concurrent.*;

/**
 * Helper class. Puts and polls number in queue.
 *
 * Created by alt-hanny on 23.08.2016.
 */
class Broker {
    /** Queue for storing numbers. */
    private static BlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);
    /**
     * Puts numbers into queue.
     * @param value Value of the generated numbers.
     * @throws InterruptedException InterruptedException.
     */
    static void put(int value) throws InterruptedException {
        queue.put(value);
    }

    /**
     * Polls numbers from queue.
     * @return Value of the generated number from queue.
     * @throws InterruptedException InterruptedException.
     */
    static Integer poll() throws InterruptedException {
        return queue.poll();
    }

    static Boolean isEmptyQueue() {
        return queue.isEmpty();
    }
}
