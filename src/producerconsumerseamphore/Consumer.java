package producerconsumerseamphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements  Runnable{
    private Queue<Object> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Consumer(Queue<Object> queue, int maxSize, String name , Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = queue;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            try {
                consumerSemaphore.acquire();
                if(store.size() > 0){
                    System.out.println(this.name + " is consuming in an atione size = " + store.size());
                    store.remove();
                }
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            }
    }
}
