package middle;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bvvy on 2017/8/11.
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int index = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            plus();
        }
    }

    public  void plus() {
        lock.lock();
        try {
            index++;
            System.out.println(index);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock, "t1");
        Thread t2 = new Thread(reenterLock, "t2");
        t1.start();
        t2.start();
    }
}
