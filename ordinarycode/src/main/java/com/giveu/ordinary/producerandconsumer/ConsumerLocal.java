package com.giveu.ordinary.producerandconsumer;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerLocal implements  Runnable {
    public ArrayBlockingQueue<String> queue;
    Logger logger=Logger.getLogger(this.getClass());
    public ConsumerLocal(ArrayBlockingQueue<String> queue) {
       this.queue=queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
               String take=queue.take();
                if (take.equals("pison"))
                    return;
               logger.info(take);
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }

    }
}
