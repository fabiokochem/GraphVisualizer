package utils;

public class Sleep {
    public static void ms(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {}
    }
}
