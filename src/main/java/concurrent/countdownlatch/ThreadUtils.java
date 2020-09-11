package concurrent.countdownlatch;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    public static void sleep(int second) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(second);
                break;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
