package producerconsumerseamphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Producer(Queue<Object> queue, int maxSize, String name , Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = queue;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true){
            try {
                producerSemaphore.acquire();
                if(store.size() < maxSize) {
                    System.out.println(this.name + "is Producer" + " " + store.size());
                    store.add((Integer) new Object());
                }
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
