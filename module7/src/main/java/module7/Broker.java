package module7;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Helper class. Puts and polls number in queue.
 *
 * Created by alt-hanny on 23.08.2016.
 */
class Broker {
    /** Queue for storing numbers. */
    private static TransferQueue<Integer> queue = new LinkedTransferQueue<>();

    /**
     * Puts numbers into queue.
     * @param value Value of the generated numbers.
     * @throws InterruptedException InterruptedException.
     */
    void put(int value) throws InterruptedException {
        queue.put(value);
    }

    /**
     * Polls numbers from queue.
     * @return Value of the generated number from queue.
     * @throws InterruptedException InterruptedException.
     */
    int poll() throws InterruptedException {
        return !queue.isEmpty() ? queue.poll(ThreadLocalRandom.current().nextInt(10, 200), TimeUnit.MILLISECONDS) : -1;
    }
}
