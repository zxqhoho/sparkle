package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch countDownLatch) {
        super("Cache Servie", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("Verifying " + this.getServiceName());
        ThreadUtils.sleep(15);
        System.out.println(this.getServiceName() + " is UP !");
    }
}
