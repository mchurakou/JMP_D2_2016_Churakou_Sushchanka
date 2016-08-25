package module7;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Hanna_Sushchanka on 8/25/2016.
 */
public class Inspector {
    CountDownLatch globalStatus;
    CountDownLatch localStatus;
    static CountDownLatch currentStatus;

    public Inspector(CountDownLatch localStatus, CountDownLatch globalStatus) {
        this.localStatus = localStatus;
        this.globalStatus = globalStatus;
    }

    public static Inspector getStatus() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Inspector inspector = null;
        if (currentStatus == null) {
            inspector = new Inspector(null, countDownLatch);
        } else {
            inspector = new Inspector(currentStatus, countDownLatch);
        }
        currentStatus = countDownLatch;
        return  inspector;
    }
}
