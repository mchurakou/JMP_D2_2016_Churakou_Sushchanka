package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Consumer thread. Handles the number. Transforms number to String and writes numbers into file.
 *
 * Created by alt-hanny on 21.08.2016.
 */
class Consumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private static final String FILE_PATH = "module7\\src\\main\\resources\\concurrency.csv";
    private Broker broker;

    Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        final Thread currentThread = Thread.currentThread();
        final String oldThreadName = currentThread.getName();
        logger.info("Consumer started " + oldThreadName);
        try {
            Integer number = broker.poll();
            if (number != -1) {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                String message = Integer.toString(number) + "- number was handled.";
                logger.info(message);
                currentThread.setName("Processing-" + message);
                logger.info(currentThread);
                writingToFile(message);
            }
            logger.info("Consumer " + currentThread + " terminated.");
        } catch (InterruptedException e) {
            logger.error("Consumer" + currentThread + "was interrapted.");
            e.printStackTrace();
        } finally {
            currentThread.setName(oldThreadName);
        }

    }

    /**
     * Writes the transformed numbers to string into the file "concurrency.cvs"
     * @param message Transformed numbers to string.
     */
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
