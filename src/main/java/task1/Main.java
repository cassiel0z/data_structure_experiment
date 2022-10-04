package task1;

import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> q=new LinkedList<>();
        queueTest t=new queueTest(q);
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(q);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
