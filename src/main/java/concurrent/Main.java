package concurrent;

import concurrent.countdownlatch.Application;

public class Main {

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = Application.checkExternalService();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        System.out.println("The validation of external services is completed ! Result is : " + result);
    }
}
