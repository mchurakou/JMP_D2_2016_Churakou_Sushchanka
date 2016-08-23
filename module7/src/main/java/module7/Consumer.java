package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by alt-hanny on 21.08.2016.
 */
public class Consumer implements Runnable {
    Logger logger = LogManager.getLogger(Consumer.class);
    private static final String FILE_PATH = "module7\\src\\main\\resources\\concurrency.csv";
    private Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        final Thread currentThread = Thread.currentThread();
        final String oldThreadName = currentThread.getName();
        logger.info("Consumer started " + Thread.currentThread().getName());
        try {
            Integer number = broker.poll();
            if (number != -1) {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                String message = Integer.toString(number) + "- number was handled.";
                currentThread.setName("Processing-" + message);
                logger.info(currentThread);
                writingToFile(message);
            }
            logger.info("Consumer " + currentThread + " terminated.");
        } catch (InterruptedException e) {
            logger.error("Consumer" + Thread.currentThread().getName() + "was interrapted.");
            e.printStackTrace();
        } finally {
            currentThread.setName(oldThreadName);
        }

    }

    private void writingToFile(String message) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)){
            writer.write(message);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
