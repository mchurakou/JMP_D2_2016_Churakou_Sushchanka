package module7;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class Runner
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        final Logger logger = LogManager.getLogger(Runner.class);
        int numberOfProducers = 10;
        int numberOfConsumers = 20;
        Broker broker = new Broker();
        final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("module7-%d").setDaemon(Boolean.FALSE).build();
        ExecutorService threadPool = Executors.newFixedThreadPool(30, threadFactory);
        logger.info("Thread pool created.");
        for(int i = 0; i < numberOfProducers; i++)
        {
            Future producerStatus = threadPool.submit(new Producer(broker));
            producerStatus.get();
        }
        for(int i = 0; i < numberOfConsumers; i++)
        {
            Future consumerStatus = threadPool.submit(new Consumer(broker));
            consumerStatus.get();
        }

        threadPool.shutdown();
        final boolean done = threadPool.awaitTermination(15, TimeUnit.SECONDS);
        logger.info("All threads terminated? {}", done);
        threadPool.shutdownNow();
    }
}
