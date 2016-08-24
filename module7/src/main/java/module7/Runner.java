package module7;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Runner for the application. Creates N producers and M consumers.
 *
 * Created by alt-hanny on 21.08.2016.
 */
public class Runner
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        final Logger logger = LogManager.getLogger(Runner.class);
        logger.info("++++++++ Application started ++++++++");
        int numberOfProducers = 10;
        int numberOfConsumers = 20;
        int poolCapacity = 30;
        Broker broker = new Broker();
        final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("module7-%d").setDaemon(Boolean.FALSE).build();
        ExecutorService threadPool = Executors.newFixedThreadPool(poolCapacity, threadFactory);
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
