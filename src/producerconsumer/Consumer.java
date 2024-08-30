package producerconsumer;

import java.util.Queue;

public class Consumer implements  Runnable{
    private Queue<Object> store;
    private int maxSize;
    private String name;
    public Consumer(Queue<Object> queue, int maxSize, String name) {
        this.store = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            synchronized (Queue.class) {
                if(store.size() > 0){
                    store.remove();
                }
            }
        }
    }
}
