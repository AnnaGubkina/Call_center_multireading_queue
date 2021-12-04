import java.util.Queue;


public class Operator implements Runnable {

    public static final int TIME_TO_SLEEP = 3000;
    Queue<String> calls;
    String name;
    public static final int CALL_CENTER_OPERATORS = 5;

    public Operator(Queue<String> calls, String name) {
        this.calls = calls;
        this.name = name;
    }

    @Override
    public void run() {

        while (Main.cycle || !calls.isEmpty()) {
            if (calls.peek() != null) {
                for (int i = 1; i <= CALL_CENTER_OPERATORS; i++) {
                    System.out.println(calls.poll() + " обработан " + name + i);
                    try {
                        Thread.sleep(TIME_TO_SLEEP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
