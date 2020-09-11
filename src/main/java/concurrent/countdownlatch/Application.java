package concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Application {
    private static CountDownLatch latch;
    private static List<BaseHealthChecker> checkers;

    public static final Application INSTANCE = new Application();

    private Application() {}

    private Application getInstance(){
        return INSTANCE;
    }

    public static boolean checkExternalService() throws InterruptedException {
        latch = new CountDownLatch(3);
        checkers = new ArrayList<>();
        checkers.add(new CacheHealthChecker(latch));
        checkers.add(new DatabaseHealthChecker(latch));
        checkers.add(new NetworkHealthChecker(latch));

        Executor executor = Executors.newFixedThreadPool(3);
        for (final BaseHealthChecker checker : checkers) {
            executor.execute(checker);
        }

        latch.await();

        for (final BaseHealthChecker checker : checkers) {
            if (!checker.isServiceUp()) {
                return false;
            }
        }
        return true;
    }
}
