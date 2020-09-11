package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {
    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        super("Database Service", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("Verifying " + this.getServiceName());
        ThreadUtils.sleep(10);
        System.out.println(this.getServiceName() + " is UP !");
    }
}
