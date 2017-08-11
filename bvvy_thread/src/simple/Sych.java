package simple;

/**
 * Created by bvvy on 2017/8/10.
 */
public class Sych implements Runnable {

    public static int index = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            increase();
        }

    }

    private synchronized void increase() {
        index++;
        System.out.println(index);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Sych(), "t1`");
        Thread t2 = new Thread(new Sych(), "t2`");
        t1.start();
        t2.start();
    }
}
