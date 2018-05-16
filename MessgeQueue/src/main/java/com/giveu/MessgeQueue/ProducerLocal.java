package com.giveu.MessgeQueue;

import org.apache.log4j.Logger;

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
            Logger logger=Logger.getLogger(this.getClass());
            logger.info(e.getMessage());
        }

    }
}