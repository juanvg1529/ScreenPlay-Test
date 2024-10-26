package co.com.screenplay.project.utils;

public class Time {

    private Time() {
    }

    public static void waiting(int waitingTime) {
        try {
            Thread.sleep(waitingTime * 1000L);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
