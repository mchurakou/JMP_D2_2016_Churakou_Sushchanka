package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Runner for the application. Creates N producers and M consumers.
 *
 * Created by alt-hanny on 21.08.2016.
 */
public class Runner
{
    public static void main( String[] args ){
        final Logger logger = LogManager.getLogger(Runner.class);
        logger.info("++++++++ Application started ++++++++");
        Broker broker = new Broker();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the maximum number of generated numbers:");
            int maxNumbers = scanner.nextInt();
            NumberGenerator.setMaxNumber(maxNumbers);
            System.out.println("Input the number of producers:");
            int numberOfProducers = scanner.nextInt();
            System.out.println("Input the number of consumers:");
            int numberOfConsumers = scanner.nextInt();
            System.out.println("Input the pool capacity");
            int poolCapacity = scanner.nextInt();
//            CountDownLatch startSignal = new CountDownLatch(1);
//            CountDownLatch doneSignal = new CountDownLatch(5);
            ExecutorService threadPool = Executors.newFixedThreadPool(poolCapacity);
            logger.info("Thread pool created.");
            for (int i = 0; i < numberOfConsumers; i++) {
                 threadPool.submit(new Consumer(broker));
//                Consumer consumer = new Consumer(broker);
//                new Thread(consumer).start();
            }
            for (int i = 0; i < numberOfProducers; i++) {
                threadPool.submit(new Producer(broker));
//                Producer producer = new Producer(broker);
//                new Thread(producer).start();
            }

            threadPool.shutdown();
            final boolean done = threadPool.awaitTermination(5, TimeUnit.MINUTES);
            logger.info("All threads terminated? {}", done);
        } catch (InterruptedException e) {
            logger.error("ThreadPool was interrupted.");
            e.printStackTrace();
        }
    }
}
