package addersubtractorwithmutex;

import addersubtractorwithmutex.Count;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    public Count count;
    public Lock lock;
    public Subtractor(Count count , Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=1;i<=10000;i++){
            lock.lock();
            count.value-=i;
            lock.unlock();
        }
    }
}
