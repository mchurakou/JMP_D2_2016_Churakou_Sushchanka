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

            System.out.println("Enter the number of producers:");
            int numberOfProducers = scanner.nextInt();
            System.out.println("Enter the number of consumers:");
            int numberOfConsumers = scanner.nextInt();
            NumberGenerator.setMaxNumber(numberOfProducers*numberOfConsumers);

            BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);
            SortedSet<String> result = Collections.synchronizedSortedSet(new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    Integer n1 = Integer.parseInt(o1.split("-")[0].trim());
                    Integer n2 = Integer.parseInt(o2.split("-")[0].trim());
                    return n1 - n2;
                }
            }));

            CountDownLatch prodLatch = new CountDownLatch(numberOfProducers);
            CountDownLatch consumLatch = new CountDownLatch(numberOfConsumers);

            ExecutorService threadPool = Executors.newFixedThreadPool(numberOfProducers + numberOfConsumers);
            List<Producer> producers = new ArrayList<>();
            CyclicBarrier producersBarrier = new CyclicBarrier(numberOfProducers, () -> {
                logger.info("Producer - Barrier action");
                queue.addAll(producers.stream().map(Producer::getNumber).collect(Collectors.toList()));
            });
            for(int i = 0; i < numberOfProducers; i++) {
                Producer producer = new Producer(prodLatch, producersBarrier);
                producers.add(producer);
                threadPool.submit(producer);
            }

            List<Consumer> consumers = new ArrayList<>();
            CyclicBarrier consumersBarrier = new CyclicBarrier(numberOfConsumers, () -> {
                logger.info("Consumer - Barrier action");
                for (Consumer consumer : consumers) {
                    String number = consumer.getMessage();
                    result.add(number);
                }
                result.forEach(taskLogger::info);
                result.clear();

            });
            for (int i = 0; i < numberOfConsumers; i++) {
                Consumer consumer = new Consumer(consumLatch, consumersBarrier, queue, result);
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
