package module7;

import com.sun.jndi.ldap.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
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
        List<Phase> phases = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the maximum number of generated numbers:");
            int maxNumbers = scanner.nextInt();
            NumberGenerator.setMaxNumber(maxNumbers);
            System.out.println("Enter the number of producers:");
            int numberOfProducers = scanner.nextInt();
            System.out.println("Enter the number of consumers:");
            int numberOfConsumers = scanner.nextInt();
            CountDownLatch prodLatch = new CountDownLatch(numberOfProducers);
            CountDownLatch consumLatch = new CountDownLatch(numberOfProducers);
            ExecutorService threadPool = Executors.newFixedThreadPool(numberOfConsumers + numberOfProducers);
            logger.info("Thread pool created.");
            for (int i = 0; i < numberOfProducers; i++) {
                threadPool.submit(new Producer(prodLatch, phases));
            }

            for (int i = 0; i < numberOfConsumers; i++) {
                threadPool.submit(new Consumer(consumLatch, phases));
            }
            prodLatch.await();
            phases.add(Phase.PRODUCERS_FINISH);
            consumLatch.await();


            threadPool.shutdown();
            final boolean done = threadPool.awaitTermination(5, TimeUnit.MINUTES);
            logger.info("All threads terminated? {}", done);
        } catch (InterruptedException e) {
            logger.error("ThreadPool was interrupted.");
            e.printStackTrace();
        }
    }
}
