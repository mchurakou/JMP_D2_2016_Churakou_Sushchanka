package module7;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * Helper class. Puts and polls number in queue.
 *
 * Created by alt-hanny on 23.08.2016.
 */
class Broker {
    /** Queue for storing numbers. */
    private static BlockingQueue <Item> queue = new PriorityBlockingQueue<>(50);
    /**
     * Puts numbers into queue.
     * @param value Value of the generated numbers.
     * @throws InterruptedException InterruptedException.
     */
    static void put(int value) throws InterruptedException {
        queue.put(new Item(value));
    }

    /**
     * Polls numbers from queue.
     * @return Value of the generated number from queue.
     * @throws InterruptedException InterruptedException.
     */
    static int poll() throws InterruptedException {
        return queue.poll().id;
    }

    static synchronized Boolean isEmptyQueue() {
        return queue.isEmpty();
    }

    static class Item implements Comparable<Item>{
        int id;

        public Item(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Item o) {
            if (o.id > id) return -1;
            if (id > o.id) return 1;
            return 0;
        }
    }
}
