import java.util.Queue;

public class ATC implements Runnable {

    private static final int CALLS = 60;
    public static final int TIME_TO_SLEEP = 1000;
    public static volatile Queue<String> calls;

    public ATC(Queue<String> calls) {
        this.calls = calls;
    }

    @Override
    public void run() {
        String call = "Абонент ";
        for (int i = 1; i <= CALLS; i++) {
            calls.offer(call + i);
            System.out.println(call + i + " ожидает обработки");
            Main.cycle = false;
            try {
                Thread.sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
