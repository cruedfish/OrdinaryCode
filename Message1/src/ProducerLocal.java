
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerLocal implements  Runnable {
    ArrayBlockingQueue<String> queue;

    public ProducerLocal(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for(int i=0;i<1000;i++){
                queue.put(i+"s");
            }
        }catch (Exception e){
        }

    }
}