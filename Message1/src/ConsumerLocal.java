
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerLocal implements  Runnable {
    public ArrayBlockingQueue<String> queue;
    public ConsumerLocal(ArrayBlockingQueue<String> queue) {
        this.queue=queue;
    }

    public void run() {
        try {
            while (true) {
                String take=queue.take();
                if (take.equals("pison"))
                    return;
                System.out.println(take);
            }
        }catch (Exception e){
        }

    }
}
