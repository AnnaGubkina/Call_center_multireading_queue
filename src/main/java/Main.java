
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Main {

    /*
    Выбрала для данной задачи реализацию ConcurrentLinkedQueue, потому что данная очередь работает быстрее чем блокирующие
    очереди, является потокобезопасной и неограниченной по вместимости. Она не блокирует потоки, в случае если коллекция пустая,
    а возвращает null. Если сделать обработку null, то можно работать дальше и с лучшей производительностью.
     */

    public static Queue<String> calls = new ConcurrentLinkedQueue<>();
    public static volatile boolean cycle = true;

    public static void main(String[] args) {

        Thread ATC = new Thread(new ATC(calls));
        ATC.start();

        Thread operator = new Thread(new Operator(calls, "Оператором "));
        operator.start();

        try {
            ATC.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Работа АТС завершена");
        try {
            operator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Работа операторов завершена");
    }
}
