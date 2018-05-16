import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public  static  void main(String[]args){
        int threadNum = Runtime.getRuntime().availableProcessors();
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new ConsumerLocal(queue));
        }
        try {
            Thread pt=new Thread(new ProducerLocal(queue));
            pt.start();
            pt.join();
            for(int j=0;j<threadNum;j++){
                queue.put("pison");
            }
            executor.shutdown();
            executor.awaitTermination(10L, TimeUnit.DAYS);
        }catch (Exception e){
        }

    }
}