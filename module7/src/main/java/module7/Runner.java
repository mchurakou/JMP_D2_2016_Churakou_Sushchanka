package module7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
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
//            System.out.println("Enter the number of the producers in the party: ");
//            int producersParty = scanner.nextInt();
//            System.out.println("Enter the number of the consumers in the party: ");
//            int consumersParty = scanner.nextInt();
            System.out.println("Enter the maximum number of generated numbers:");
            int maxNumbers = scanner.nextInt();
            NumberGenerator.setMaxNumber(maxNumbers);
            System.out.println("Enter the number of producers:");
            int numberOfProducers = scanner.nextInt();
            System.out.println("Enter the number of consumers:");
            int numberOfConsumers = scanner.nextInt();

            BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);

            List<Producer> producers = new ArrayList<>();
            CyclicBarrier producersBarrier = new CyclicBarrier(numberOfProducers, () -> {
                logger.info("Barrier action");
                queue.addAll(producers.stream().map(Producer::getNumber).collect(Collectors.toList()));
            });

            List<Consumer> consumers = new ArrayList<>();
            CyclicBarrier consumersBarrier = new CyclicBarrier(numberOfConsumers, () -> {
                for (Consumer consumer: consumers) {
                    SortedSet<String> result = consumer.getResult();
                    for (String message : result) {
                        taskLogger.info(message);
                    }
                }
            });

            CountDownLatch prodLatch = new CountDownLatch(numberOfProducers);
            CountDownLatch consumLatch = new CountDownLatch(numberOfConsumers);

            ExecutorService threadPool = Executors.newFixedThreadPool(numberOfProducers + numberOfConsumers);
            for(int i = 0; i < numberOfProducers; i++) {
                Producer producer = new Producer(prodLatch, producersBarrier);
                producers.add(producer);
                threadPool.submit(producer);
            }

            for (int i = 0; i < numberOfConsumers; i++) {
                Consumer consumer = new Consumer(consumLatch, consumersBarrier, queue);
                consumers.add(consumer);
                threadPool.submit(consumer);
            }

            prodLatch.await();
            isProdusersFinished.countDown();
            consumLatch.await();
            threadPool.shutdown();
            final boolean done = (threadPool.awaitTermination(15, TimeUnit.SECONDS));
            logger.info("All threads terminated? {}", done);
        } catch (InterruptedException e) {
            logger.error("ThreadPool was interrupted.");
            e.printStackTrace();
        }
    }
}
