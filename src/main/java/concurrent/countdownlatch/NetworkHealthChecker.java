package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(CountDownLatch countDownLatch) {
        super("Network Service", countDownLatch);
    }

    @Override
    public void verifyService() {
        System.out.println("verifying " + this.getServiceName());
        ThreadUtils.sleep(5);
        System.out.println(this.getServiceName() + " is UP !");
    }
}
