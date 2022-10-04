package task1;

import java.util.Queue;

public class queueTest implements Runnable{
    private final Queue<Integer> q;


    queueTest(Queue<Integer> q){
        this.q=q;
    }

    @Override
    public synchronized void run(){
        System.out.println(Thread.currentThread().getName()+"running");
        for (int i = 0; i<10; i++){
            System.out.print(i);
            q.add(i);
        }
        System.out.println();
    }


    public Queue<Integer> getQueue(){
        return q;
    }
}
