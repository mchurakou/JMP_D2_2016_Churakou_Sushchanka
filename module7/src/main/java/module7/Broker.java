package module7;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by alt-hanny on 23.08.2016.
 */
public class Broker {
    private static TransferQueue<Integer> queue = new LinkedTransferQueue<>();

    public void put(int value) throws InterruptedException {
        queue.put(value);
    }

    public int poll() throws InterruptedException {
        return !queue.isEmpty() ? queue.poll(ThreadLocalRandom.current().nextInt(10, 200), TimeUnit.MILLISECONDS) : -1;
    }
}
