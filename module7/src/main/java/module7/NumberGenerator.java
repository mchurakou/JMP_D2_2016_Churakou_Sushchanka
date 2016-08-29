package module7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alt-hanny on 21.08.2016.
 */
class NumberGenerator {
    static private AtomicInteger numberAtomic = new AtomicInteger();
    static private int maxNumber;

    static void setMaxNumber(int maxNumber) {
        NumberGenerator.maxNumber = maxNumber;
    }

    static int getMaxNumber() {
        return maxNumber;
    }

    static int getNumber() {
        int value = numberAtomic.get();
        return (!numberAtomic.compareAndSet(maxNumber, value)) ? numberAtomic.incrementAndGet() : Integer.MIN_VALUE;
    }
}
