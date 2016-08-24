package module7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Helper class. Puts and polls number in queue.
 *
 * Created by alt-hanny on 23.08.2016.
 */
class Broker {
    /** Queue for storing numbers. */
    private static BlockingQueue <Numb> queue = new PriorityBlockingQueue<>(10);

    /**
     * Puts numbers into queue.
     * @param value Value of the generated numbers.
     * @throws InterruptedException InterruptedException.
     */
    static void put(Integer value) throws InterruptedException {
        queue.put(new Numb(value));
    }

    /**
     * Polls numbers from queue.
     * @return Value of the generated number from queue.
     * @throws InterruptedException InterruptedException.
     */
    static String poll() throws InterruptedException {
        return queue.poll().toString();
    }

    static Boolean isEmptyQueue() {
        return queue.isEmpty();
    }

    static class Numb implements Comparable<Numb> {
        int value;
        Numb (int value) {
            this.value = value;
        }
        @Override
        public int compareTo(Numb o) {
            if (o.value > value) return -1;
            if (value > o.value) return 1;
            return 0;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
