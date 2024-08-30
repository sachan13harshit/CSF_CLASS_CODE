package producerconsumer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ArrayDeque<>();
        int maxsize = 6;
        Producer p1 = new Producer(store , maxsize , "P1");
        Producer p2 = new Producer(store , maxsize , "P2");
        Producer p3 = new Producer(store , maxsize , "P3");
        Producer p4 = new Producer(store , maxsize , "P4");


        Consumer c1 = new Consumer(store , maxsize , "c1");
        Consumer c2 = new Consumer(store , maxsize , "c2");
        Consumer c3 = new Consumer(store , maxsize , "c3");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(c1);
        Thread t6 = new Thread(c2);
        Thread t7 = new Thread(c3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();


    }
}
