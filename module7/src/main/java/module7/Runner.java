package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static module7.Consumer.result;

/**
 * Runner for the application. Creates N producers and M consumers.
 *
 * Created by alt-hanny on 21.08.2016.
 */
public class Runner
{
    static CountDownLatch isProdusersFinished = new CountDownLatch(1);
    public static void main( String[] args ){
        final Logger logger = LogManager.getLogger(Runner.class);
        final Logger taskLogger = LogManager.getLogger("ConcurrencyTaskLogger");
        logger.info("++++++++ Application started ++++++++");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the maximum number of generated numbers:");
            int maxNumbers = scanner.nextInt();
            NumberGenerator.setMaxNumber(maxNumbers);
            System.out.println("Enter the number of producers:");
            int numberOfProducers = scanner.nextInt();
            System.out.println("Enter the number of consumers:");
            int numberOfConsumers = scanner.nextInt();

            BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);

            CountDownLatch prodLatch = new CountDownLatch(numberOfProducers);
            CountDownLatch consumLatch = new CountDownLatch(numberOfConsumers);

            Producer producer = new Producer(prodLatch, queue);
            Consumer consumer = new Consumer(consumLatch, queue);
            ExecutorService threadPool = Executors.newFixedThreadPool(numberOfProducers + numberOfConsumers);
            for(int i = 0; i < numberOfProducers; i++)
                threadPool.submit(producer);
            for (int i = 0; i < numberOfConsumers; i++)
                threadPool.submit(consumer);

            prodLatch.await();
            isProdusersFinished.countDown();
            consumLatch.await();
            threadPool.shutdown();
            final boolean done = (threadPool.awaitTermination(15, TimeUnit.SECONDS));
            logger.info("All threads terminated? {}", done);
            result.forEach(taskLogger::info);
        } catch (InterruptedException e) {
            logger.error("ThreadPool was interrupted.");
            e.printStackTrace();
        }
    }
}
