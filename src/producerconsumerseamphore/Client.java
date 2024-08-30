package producerconsumerseamphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ConcurrentLinkedQueue<>();
        int maxsize = 6;
        Semaphore producerSeamaphore = new Semaphore(6);
        Semaphore consumerSeamaphore = new Semaphore(0);

        Producer p1 = new Producer(store , maxsize , "p1" , producerSeamaphore , consumerSeamaphore);
        Producer p2 = new Producer(store , maxsize , "p2" , producerSeamaphore , consumerSeamaphore);
        Producer p3 = new Producer(store , maxsize , "p3" , producerSeamaphore , consumerSeamaphore);
        Producer p4 = new Producer(store , maxsize , "p4" , producerSeamaphore , consumerSeamaphore);
        Consumer c1 = new Consumer(store , maxsize , "c1" , producerSeamaphore , consumerSeamaphore);
        Consumer c2 = new Consumer(store , maxsize , "c2" , producerSeamaphore , consumerSeamaphore);
        Consumer c3 = new Consumer(store , maxsize , "c3" , producerSeamaphore , consumerSeamaphore);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(c1);
        Thread t6 = new Thread(c2);
        Thread t7 = new Thread(c3);
    }
}
