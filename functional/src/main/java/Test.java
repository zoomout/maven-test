/**
 * Created by zoomout on 9/30/16.
 */
public class Test {
    public static void main(String[] args) {
        Runnable runnable = runnable();
        runnable.run(); // Breakpoint here
    }

    static Runnable runnable() {
        return () -> {
            System.out.println("Hello");
        };
    }
}
