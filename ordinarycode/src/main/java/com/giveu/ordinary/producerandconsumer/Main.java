package com.giveu.ordinary.producerandconsumer;

import java.util.concurrent.*;

public class Main {
    public  void  main(String[]args) throws  Exception {
        int threadNum = Runtime.getRuntime().availableProcessors();
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new ConsumerLocal(queue));
        }
        Thread pt=new Thread(new ProducerLocal(queue));
        pt.start();
        pt.join();
        for(int j=0;j<threadNum;j++){
            queue.put("pison");
        }
        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.DAYS);
    }
}
